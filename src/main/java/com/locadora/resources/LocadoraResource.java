package com.locadora.resources;

import com.locadora.domains.Locadora;
import com.locadora.domains.dtos.LocadoraDTO;
import com.locadora.services.LocadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/locadora")
public class LocadoraResource {
    @Autowired
    private LocadoraService locadoraService;

    @GetMapping // exemplo http://localhost:8080/locadora
    public ResponseEntity<List<LocadoraDTO>> findAll(){
        return ResponseEntity.ok().body(locadoraService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocadoraDTO> findById(@PathVariable Integer id){
        Locadora obj = this.locadoraService.findById(id);
        return ResponseEntity.ok().body(new LocadoraDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<LocadoraDTO> findByCnpj(@PathVariable String cnpj){
        Locadora obj = this.locadoraService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new LocadoraDTO(obj));
    }


    @PostMapping
    public ResponseEntity<LocadoraDTO> create(@Valid @RequestBody LocadoraDTO dto){
        Locadora locadora = locadoraService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(locadora.getIdLocadora()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LocadoraDTO> update(@PathVariable Integer id, @Valid @RequestBody LocadoraDTO objDto){
        Locadora Obj = locadoraService.update(id, objDto);
        return ResponseEntity.ok().body(new LocadoraDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LocadoraDTO> delete(@PathVariable Integer id){
        locadoraService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
