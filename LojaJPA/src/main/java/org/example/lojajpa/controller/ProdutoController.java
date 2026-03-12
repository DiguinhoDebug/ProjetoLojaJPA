package org.example.lojajpa.controller;


import org.example.lojajpa.model.Produto;
import org.example.lojajpa.repository.ProdutoRepository;
import org.example.lojajpa.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//permite operações do HTTP, get, post, put, delete
@RequestMapping("/produtos")//Request mapping, solicitação do servidor
public class ProdutoController {
    private final ProdutoService service; //mesma coisa que fizemos no repository, só que agora é chamando o service
    //afinal ele tem os nossos métodos

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar(){// chamamos o listar que esta no service para o listar que tá no GetMapping, uma coisa chama a outra
        return service.listar();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto){//o request vai transformar o objeto em JSON pra fazer a comunicação
        return service.inserir(produto);
    }
}
