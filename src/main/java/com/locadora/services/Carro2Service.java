package com.locadora.services;

import com.locadora.domains.Carro2;
import com.locadora.domains.dtos.Carro2DTO;
import com.locadora.repositories.Carro2Repository;
import com.locadora.services.exceptions.DataIntegrityViolationException;
import com.locadora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Carro2Service {

    @Autowired
    private Carro2Repository carro2Repo;

    public List<Carro2DTO> findAll(){
        return carro2Repo.findAll().stream()
                .map(obj -> new Carro2DTO(obj))
                .collect(Collectors.toList());
    }

    public Carro2 findByCpf(String cpfProprietario) {
        Optional<Carro2> obj = carro2Repo.findByCpfProprietario(cpfProprietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("CPF Não Encontrado! CPF: " + cpfProprietario));
    }

    public Carro2 findById(Integer id){
        Optional<Carro2> obj = carro2Repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro Não Encontrado! ID: "+ id));
    }

    public Carro2 create (Carro2DTO dto){
        dto.setIdCarro(null);
        validaCarro(dto);
        Carro2 obj = new Carro2(dto);
        return carro2Repo.save(obj);
    }

    public Carro2 update(Integer id, Carro2DTO objDto){
        objDto.setIdCarro(id);
        Carro2 oldObj = findById(id);
        validaCarro(objDto);
        oldObj = new Carro2(objDto);
        return carro2Repo.save(oldObj);
    }

    private void validaCarro(Carro2DTO dto){
        Optional<Carro2> objCpf = carro2Repo.findByCpfProprietario(dto.getCpfProprietario());
        if (objCpf.isPresent() && objCpf.get().getIdCarro() != dto.getIdCarro()){
            throw new DataIntegrityViolationException("Carro já Cadastrada!");
        }
        if(!carro2Repo.existsById(dto.getIdCarro())){
            throw new DataIntegrityViolationException("Carro de proprietario não encontrado! ID: "+dto.getIdCarro());
        }
    }

    public void delete (Integer id){
        Carro2 obj = findById(id);
        carro2Repo.deleteById(id);
    }
}
