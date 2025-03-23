package com.locadora.services;

import com.locadora.domains.Locadora;
import com.locadora.domains.dtos.LocadoraDTO;
import com.locadora.repositories.LocadoraRepository;
import com.locadora.services.exceptions.DataIntegrityViolationException;
import com.locadora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocadoraService {

    @Autowired
    private LocadoraRepository locadoraRepo;

    //Retorna uma lista de LocadoraDTO
    public List<LocadoraDTO> findAll(){
        return locadoraRepo.findAll().stream()
                .map(obj -> new LocadoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Locadora findById(Integer id){
        Optional<Locadora> obj = locadoraRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Locadora Não Encontrado! ID: "+ id));
    }

    public Locadora findByCnpj(String cnpj){
        Optional<Locadora> obj = locadoraRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Locadora Não Encontrada! CNPJ: "+ cnpj));
    }

    public Locadora create (LocadoraDTO dto){
        dto.setIdLocadora(null);
        validaEstabelecimento(dto);
        Locadora obj = new Locadora(dto);
        return locadoraRepo.save(obj);
    }

    private void validaEstabelecimento(LocadoraDTO dto){
        Optional<Locadora> obj = locadoraRepo.findByCnpj(dto.getCnpj());
        if (obj.isPresent() && obj.get().getIdLocadora() != dto.getIdLocadora()){
            throw new DataIntegrityViolationException("CNPJ já Cadastrado!");
        }
    }

    public Locadora update(Integer id, LocadoraDTO objDto){
        objDto.setIdLocadora(id);
        Locadora oldObj = findById(id);
        validaEstabelecimento(objDto);
        oldObj = new Locadora(objDto);
        return locadoraRepo.save(oldObj);
    }

    public void delete(Integer id){
        Locadora obj = findById(id);

        if (obj.getClientes().size()>0){
            throw new DataIntegrityViolationException("Locadora não pode ser Deletado pois possui clientes vinculados!");
        }

        if (obj.getCarros().size()>0){
            throw new DataIntegrityViolationException("Locadora não pode ser Deletado pois possui carros vinculados!");
        }

        locadoraRepo.deleteById(id);
    }

}
