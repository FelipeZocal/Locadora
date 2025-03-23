package com.locadora.resources;

import com.locadora.domains.Carro;
import com.locadora.domains.dtos.CarroDTO;
import com.locadora.services.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/carro")
public class CarroResource {
    @Autowired
    private CarroService carroService;

    @GetMapping // exemplo http://localhost:8080/carro
    public ResponseEntity<List<CarroDTO>> findAll(){
        return ResponseEntity.ok().body(carroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Integer id){
        Carro obj = this.carroService.findById(id);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @GetMapping(value = "/placa/{placa}")
    public ResponseEntity<CarroDTO> findByRg(@PathVariable String placa){
        Carro obj = this.carroService.findByPlaca(placa);
        return ResponseEntity.ok().body(new CarroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO dto){
        Carro carro = carroService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(carro.getIdCarro()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Integer id, @Valid @RequestBody CarroDTO objDto){
        Carro Obj = carroService.update(id, objDto);
        return ResponseEntity.ok().body(new CarroDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> delete(@PathVariable Integer id){
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
