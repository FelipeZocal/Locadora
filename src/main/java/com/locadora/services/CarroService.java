package com.locadora.services;

import com.locadora.domains.Carro;
import com.locadora.domains.dtos.CarroDTO;
import com.locadora.repositories.CarroRepository;
import com.locadora.repositories.LocadoraRepository;
import com.locadora.services.exceptions.DataIntegrityViolationException;
import com.locadora.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {


    @Autowired
    private CarroRepository carroRepo;

    @Autowired
    private LocadoraRepository locadoraRepo;

    //Retorna uma lista de CarroDTO
    public List<CarroDTO> findAll(){
        return carroRepo.findAll().stream()
                .map(obj -> new CarroDTO(obj))
                .collect(Collectors.toList());
    }

    public Carro findById(Integer id){
        Optional<Carro> obj = carroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro Não Encontrado! ID: "+ id));
    }

    public Carro findByPlaca(String placa){
        Optional<Carro> obj = carroRepo.findByPlaca(placa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro Não Encontrado! PLACA: "+ placa));
    }

    public Carro create (CarroDTO dto){
        dto.setIdCarro(null);
        validaCarro(dto);
        Carro obj = new Carro(dto);
        return carroRepo.save(obj);
    }

    private void validaCarro(CarroDTO dto){
        Optional<Carro> objRg = carroRepo.findByPlaca(dto.getPlaca());
        if (objRg.isPresent() && objRg.get().getIdCarro() != dto.getIdCarro()){
            throw new DataIntegrityViolationException("PLACA já Cadastrada!");
        }
        // Valida se a locadora associada existe
        if (!locadoraRepo.existsById(dto.getLocadora())) {
            throw new DataIntegrityViolationException("Locadora associada não encontrada! ID: "+ dto.getLocadora());
        }
    }

    public Carro update(Integer id, CarroDTO objDto){
        objDto.setIdCarro(id);
        Carro oldObj = findById(id);
        validaCarro(objDto);
        oldObj = new Carro(objDto);
        return carroRepo.save(oldObj);
    }

    public void delete(Integer id){
        Carro obj = findById(id);
        carroRepo.deleteById(id);
    }
}
