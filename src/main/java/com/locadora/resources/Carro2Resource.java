package com.locadora.resources;


import com.locadora.domains.Carro2;
import com.locadora.domains.dtos.Carro2DTO;
import com.locadora.services.Carro2Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/carro2")
public class Carro2Resource {

    @Autowired
    private Carro2Service carro2Service;

    @GetMapping //http://localhost:8080/carroteste2
    public ResponseEntity<List<Carro2DTO>> findAll(){
        return ResponseEntity.ok().body(carro2Service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carro2DTO> findById(@PathVariable Integer id){
        Carro2 obj = this.carro2Service.findById(id);
        return ResponseEntity.ok().body(new Carro2DTO(obj));
    }

    @GetMapping(value = "/cpfProprietario/{cpfProprietario}")
    public ResponseEntity<Carro2DTO> findByCpf(@PathVariable String cpfProprietario){
        Carro2 obj = this.carro2Service.findByCpf(cpfProprietario);
        return ResponseEntity.ok().body(new Carro2DTO(obj));
    }

    @PostMapping
    public ResponseEntity<Carro2DTO> create(@Valid @RequestBody Carro2DTO dto){
        Carro2 carro = carro2Service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(carro.getIdCarro()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Carro2DTO> update(@PathVariable Integer id, @Valid @RequestBody Carro2DTO objDto){
        Carro2 Obj = carro2Service.update(id, objDto);
        return ResponseEntity.ok().body(new Carro2DTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Carro2DTO> delete(@PathVariable Integer id){
        carro2Service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
