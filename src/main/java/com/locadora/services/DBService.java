package com.locadora.services;

import com.locadora.domains.*;
import com.locadora.domains.enums.Aprovacao;
import com.locadora.domains.enums.Conservacao;
import com.locadora.domains.enums.OrdemAluguel;
import com.locadora.domains.enums.PrioridadeAluguel;
import com.locadora.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private LocadoraRepository locadoraRepo;

    @Autowired
    private CarroRepository carroRepo;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepo;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepo;

    @Autowired
    private OrdemServicoRepository ordemServicoRepo;

    public void initDB(){

        //  Pessoa Juridica
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(null,"Arthur Zocal Ribeiro da Silva", "000.000.000-00", "arthur@gmail.com","111");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(null,"Felipe Zocal Medes", "111.111.111-11", "felipe@gmail.com","111");

        //  Pessoa Fisica
        PessoaFisica pessoaFisica1 = new PessoaFisica(null,"Arthur Ribeiro da Silva", "100.000.000-00", "arthurz@gmail.com","2122");
        PessoaFisica pessoaFisica2 = new PessoaFisica(null,"Felipe Medes", "121.111.111-11", "felipez@gmail.com","2212");

        //  Ordem Servico
        OrdemServico ordemServico1 = new OrdemServico(null, "Primeira", "PrimeiraOrdem", PrioridadeAluguel.ESPERA, OrdemAluguel.ANALISE,pessoaJuridica1,pessoaFisica1);
        OrdemServico ordemServico2 = new OrdemServico(null, "Segunda", "SegundaOrdem", PrioridadeAluguel.APROVADO, OrdemAluguel.LOCADO,pessoaJuridica2,pessoaFisica2);

        //  Locadora
        Locadora locadora1 = new Locadora(null,"Locadora1","CNPJ1","Rua São Paulo",111,0);
        Locadora locadora2 = new Locadora(null, "Locadora2", "CNPJ2", "Rua Bahia", 222, 4);

        //  Cliente
        Cliente cliente1 = new Cliente(null,"Cliente1","RG1","CPF1", LocalDate.now(),"Rua Pernambuco",1111,"Sem Histórico", locadora1, Aprovacao.APROVADO);
        Cliente cliente2 = new Cliente(null ,"Cliente2", "RG2", "CPF2", LocalDate.now(), "Rua Salvador", 2222, "Ativo", locadora2, Aprovacao.EMANALISE);

        //  Carro
        Carro carro1 = new Carro(null,"BMW","X6","Branco",2020, new BigDecimal("350.50"),LocalDate.now(),"BMWX6",2500,4,"9999",locadora1, Conservacao.BOM);
        Carro carro2 = new Carro(null,"Ford","F250","Verde",2000, new BigDecimal("650.50"),LocalDate.now(),"F250",2500,2,"8888",locadora1, Conservacao.RAZOAVEL);
        Carro carro3 = new Carro(null,"Chevrolet","Corsa","Branco",2009, new BigDecimal("250.50"),LocalDate.now(),"CORSA",2500,2,"7777",locadora1, Conservacao.RUIM);
        Carro carro4 = new Carro(null,"FIAT","Strada","Prata",2018, new BigDecimal("300.50"),LocalDate.now(),"STRADA",2500,2,"6666",locadora1, Conservacao.RAZOAVEL);
        Carro carro5 = new Carro(null,"Honda","Civic","Branco",2020, new BigDecimal("350.50"),LocalDate.now(),"CIVIC",2000,4,"5555",locadora1, Conservacao.BOM);
        Carro carro6 = new Carro(null, "Toyota", "Corolla", "Preto", 2016, new BigDecimal("340.00"), LocalDate.now(), "COROLLA", 1100, 4, "4444", locadora2, Conservacao.BOM);

        pessoaJuridicaRepo.save(pessoaJuridica1);
        pessoaJuridicaRepo.save(pessoaJuridica2);

        pessoaFisicaRepo.save(pessoaFisica1);
        pessoaFisicaRepo.save(pessoaFisica2);

        ordemServicoRepo.save(ordemServico1);
        ordemServicoRepo.save(ordemServico2);

        locadoraRepo.save(locadora1);
        locadoraRepo.save(locadora2);

        clienteRepo.save(cliente1);
        clienteRepo.save(cliente2);

        carroRepo.save(carro1);
        carroRepo.save(carro2);
        carroRepo.save(carro3);
        carroRepo.save(carro4);
        carroRepo.save(carro5);
        carroRepo.save(carro6);
    }


}
