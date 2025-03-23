package com.locadora.services;

import com.locadora.domains.dtos.OrdemServicoDTO;
import com.locadora.domains.OrdemServico;
import com.locadora.domains.PessoaFisica;
import com.locadora.domains.PessoaJuridica;
import com.locadora.domains.dtos.PessoaJuridicaDTO;
import com.locadora.domains.enums.PrioridadeAluguel;
import com.locadora.repositories.OrdemServicoRepository;
import com.locadora.services.exceptions.DataIntegrityViolationException;
import com.locadora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepo;

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    public OrdemServico findById(UUID id) {
        Optional<OrdemServico> obj = ordemServicoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Ordem não encontrada! ID: " + id));
    }

    public OrdemServico findByTituloOS(String tituloOS){
        Optional<OrdemServico> obj = ordemServicoRepo.findByTituloOS(tituloOS);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Titulo de ordem de serviço não encontrado! Titulo: "+tituloOS));
    }
    public List<OrdemServicoDTO> findAll() {
        return ordemServicoRepo.findAll().stream()
                .map(obj -> new OrdemServicoDTO(obj)).collect(Collectors.toList());
    }

    private OrdemServico novaOrdemServico(OrdemServicoDTO obj) {
        PessoaJuridica pessoaJuridica = pessoaJuridicaService.findById(obj.getPessoaJuridica());
        PessoaFisica pessoaFisica = pessoaFisicaService.findById(obj.getPessoaFisica());

        OrdemServico os = new OrdemServico();
        if (obj.getId() != null) {
            os.setId(obj.getId());
        }
        if (obj.getOrdemStatus().equals(2)) {
            os.setDataFim(LocalDate.now());
        }

        os.setPessoaJuridica(pessoaJuridica);
        os.setPessoaFisica(pessoaFisica);
        os.setPrioridadeAluguel(PrioridadeAluguel.toEnum(obj.getPrioridadeAluguel()));
        os.setTituloOS(obj.getTituloOS());
        os.setDescricao(obj.getDescricao());
        return os;
    }

    public OrdemServico create(OrdemServicoDTO objDto) {
        return ordemServicoRepo.save(novaOrdemServico(objDto));
    }

    public OrdemServico update(UUID id, OrdemServicoDTO objDto) {
        objDto.setId(id);
        OrdemServico oldObj = findById(id);
        oldObj = novaOrdemServico(objDto);
        return ordemServicoRepo.save(oldObj);
    }

    public void delete(UUID id) {
        OrdemServico obj = findById(id);
        if (obj.getId() != null) {
            throw new DataIntegrityViolationException("Esta ordem de serviço não pode ser deletada pois esta vinculada ao ID: " + id);
        }

        ordemServicoRepo.deleteById(id);
    }

    private void ValidaPorTitulo(OrdemServicoDTO objDto) {
        Optional<OrdemServico> obj = ordemServicoRepo.findByTituloOS(objDto.getTituloOS());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Titulo ja cadastrado no sistema!");
        }
    }
}
