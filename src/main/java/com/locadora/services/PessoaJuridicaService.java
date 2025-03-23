package com.locadora.services;

import com.locadora.domains.PessoaJuridica;
import com.locadora.domains.dtos.PessoaJuridicaDTO;
import com.locadora.repositories.PessoaJuridicaRepository;
import com.locadora.services.exceptions.DataIntegrityViolationException;
import com.locadora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepo;

    public List<PessoaJuridicaDTO> findAll(){
        return pessoaJuridicaRepo.findAll().stream()
                .map(obj -> new PessoaJuridicaDTO(obj)).collect(Collectors.toList());
    }

    public PessoaJuridica findById(Long id){
        Optional<PessoaJuridica> obj = pessoaJuridicaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id));
    }

    public PessoaJuridica findByEmail(String email){
        Optional<PessoaJuridica> obj = pessoaJuridicaRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email: "+email));
    }

    public PessoaJuridica create (PessoaJuridicaDTO objDto){
        objDto.setId(null);
        ValidaPorEmail(objDto);
        PessoaJuridica newObj = new PessoaJuridica(objDto);
        return pessoaJuridicaRepo.save(newObj);
    }

    public PessoaJuridica update(Long id, PessoaJuridicaDTO objDto){
        objDto.setId(id);
        PessoaJuridica oldObj = findById(id);
        ValidaPorEmail(objDto);
        oldObj = new PessoaJuridica(objDto);
        return pessoaJuridicaRepo.save(oldObj);
    }

    public void delete(Long id){
        PessoaJuridica obj = findById(id);
        if(obj.getOrdemServico().size()>0){
            throw new DataIntegrityViolationException("Esta pessoa jurídica não pode ser deletada pois possui ordens de serviço pendentes!");
        }
        pessoaJuridicaRepo.deleteById(id);
    }

    private void ValidaPorEmail(PessoaJuridicaDTO objDto){
        Optional<PessoaJuridica> obj = pessoaJuridicaRepo.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }

    }
}
