package com.locadora.resources;

import com.locadora.domains.OrdemServico;
import com.locadora.domains.dtos.OrdemServicoDTO;
import com.locadora.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping(value="/ordemservico")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping //https://localhost:8080/ordemservico
    public ResponseEntity<List<OrdemServicoDTO>> findAll() {
        return ResponseEntity.ok().body(ordemServicoService.findAll());
    }

    @GetMapping(value="/{id}")//https://localhost:8080/ordemservico/1
    public ResponseEntity<OrdemServicoDTO> findById(UUID id) {
        OrdemServico obj = this.ordemServicoService.findById(id);
            return ResponseEntity.ok().body(new OrdemServicoDTO(obj));
    }

    @GetMapping(value="/{titulo}")//https://localhost:8080/ordemservico/titulo1
    public ResponseEntity<OrdemServicoDTO> findByTituloOS(String tituloOS) {
        OrdemServico obj = this.ordemServicoService.findByTituloOS(tituloOS);
        return ResponseEntity.ok().body(new OrdemServicoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> create(OrdemServicoDTO objDto){
        OrdemServico newObj = ordemServicoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<OrdemServicoDTO> update(UUID id, OrdemServicoDTO objDto){
        OrdemServico Obj = ordemServicoService.update(id, objDto);
        return ResponseEntity.ok().body(new OrdemServicoDTO(Obj));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<OrdemServicoDTO> delete(UUID id){
        ordemServicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

