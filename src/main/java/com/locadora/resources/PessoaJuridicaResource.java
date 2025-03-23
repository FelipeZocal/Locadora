package com.locadora.resources;

import com.locadora.domains.Pessoa;
import com.locadora.domains.PessoaJuridica;
import com.locadora.domains.dtos.PessoaJuridicaDTO;
import com.locadora.services.PessoaJuridicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoaJuridica")
public class PessoaJuridicaResource {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @GetMapping //http://localhost:8080/pessoaJuridica
    public ResponseEntity<List<PessoaJuridicaDTO>> findAll(){
        return ResponseEntity.ok().body(pessoaJuridicaService.findAll());
    }

    @GetMapping(value = "/{id}")//http://localhost:8080/pessoaJuridica/1
    public ResponseEntity<PessoaJuridicaDTO> findById(Long id){
        PessoaJuridica obj = this.pessoaJuridicaService.findById(id);
        return ResponseEntity.ok().body(new PessoaJuridicaDTO(obj));
    }

    @GetMapping(value = "/email/{email}")//http://localhost:8080/pessoaJuridica/email@email.com
    public ResponseEntity<PessoaJuridicaDTO> findByEmail(String email){
        PessoaJuridica obj = this.pessoaJuridicaService.findByEmail(email);
        return ResponseEntity.ok().body(new PessoaJuridicaDTO());
    }

    @PostMapping
    public ResponseEntity<PessoaJuridicaDTO> create(@Valid @RequestBody PessoaJuridicaDTO objDto){
        PessoaJuridica newObj = pessoaJuridicaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<PessoaJuridicaDTO> update(@PathVariable Long id, @Valid @RequestBody PessoaJuridicaDTO objDto){
        PessoaJuridica Obj = pessoaJuridicaService.update(id, objDto);
        return ResponseEntity.ok().body(new PessoaJuridicaDTO(Obj));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<PessoaJuridicaDTO> delete(@PathVariable Long id){
        pessoaJuridicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
