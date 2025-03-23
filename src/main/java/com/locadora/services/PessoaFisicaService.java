package com.locadora.services;


import com.locadora.domains.PessoaFisica;
import com.locadora.domains.dtos.PessoaFisicaDTO;
import com.locadora.repositories.PessoaFisicaRepository;
import com.locadora.services.exceptions.DataIntegrityViolationException;
import com.locadora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepo;

    public List<PessoaFisicaDTO> findAll(){
        return pessoaFisicaRepo.findAll().stream()
                .map(obj -> new PessoaFisicaDTO(obj)).collect(Collectors.toList());
    }

    public PessoaFisica findById(Long id){
        Optional<PessoaFisica> obj = pessoaFisicaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id));
    }

    public PessoaFisica findByEmail(String email){
        Optional<PessoaFisica> obj = pessoaFisicaRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email: "+email));
    }

    public PessoaFisica create(PessoaFisicaDTO objDto){
        objDto.setId(null);
        ValidaPorEmail(objDto);
        PessoaFisica newObj = new PessoaFisica(objDto);
        return pessoaFisicaRepo.save(newObj);
    }

    public PessoaFisica update(Long id, PessoaFisicaDTO objDto){
        objDto.setId(id);
        PessoaFisica oldObj = findById(id);
        ValidaPorEmail(objDto);
        oldObj = new PessoaFisica(objDto);
        return pessoaFisicaRepo.save(oldObj);
    }

    public void delete(Long id){
        PessoaFisica obj = findById(id);
        if(obj.getOrdemServicos().size()>0){
            throw new DataIntegrityViolationException("Pessoa não pode ser deletada pois possui" +
                    "ordens de serviço pendentes!");
        }
        pessoaFisicaRepo.deleteById(id);
    }

    private void ValidaPorEmail(PessoaFisicaDTO objDto){
        Optional<PessoaFisica> obj = pessoaFisicaRepo.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }
    }
}
