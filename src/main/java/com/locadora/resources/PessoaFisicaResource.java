package com.locadora.resources;

import com.locadora.domains.PessoaFisica;
import com.locadora.domains.dtos.PessoaFisicaDTO;
import com.locadora.services.PessoaFisicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/pessoaFisica")
public class PessoaFisicaResource {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping //http://localhost:8080/pessoaFisica
    public ResponseEntity<List<PessoaFisicaDTO>> findAll(){
        return ResponseEntity.ok().body(pessoaFisicaService.findAll());
    }

    @GetMapping(value = "/{id}")//http://localhost:8080/pessoaFisicaa/1
    public ResponseEntity<PessoaFisicaDTO> findById(Long id){
        PessoaFisica obj = this.pessoaFisicaService.findById(id);
        return ResponseEntity.ok().body(new PessoaFisicaDTO(obj));
    }

    @GetMapping(value = "/email/{email}")//http://localhost:8080/pessoaFisica/email@email.com
    public ResponseEntity<PessoaFisicaDTO> findByEmail(String email){
        PessoaFisica obj = this.pessoaFisicaService.findByEmail(email);
        return ResponseEntity.ok().body(new PessoaFisicaDTO());
    }

    @PostMapping
    public ResponseEntity<PessoaFisicaDTO> create(@Valid @RequestBody PessoaFisicaDTO objDto){
        PessoaFisica newObj = pessoaFisicaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<PessoaFisicaDTO> update(@PathVariable Long id, @Valid @RequestBody PessoaFisicaDTO objDto){
        PessoaFisica Obj = pessoaFisicaService.update(id, objDto);
        return ResponseEntity.ok().body(new PessoaFisicaDTO(Obj));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<PessoaFisicaDTO> delete(@PathVariable Long id){
        pessoaFisicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
