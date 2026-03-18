package org.example.lojajpa.controller;


import jakarta.validation.Valid;
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
    public Produto criar(@RequestBody @Valid Produto produto){//o request vai transformar o objeto em JSON pra fazer a comunicação
        return service.inserir(produto);
    } //@Valid apenas procura a validação pra ver se os parâmetros estão válidos

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody @Valid Produto produto){ //Pegamos o ID antigo e o produto antigo
        produto.setId(id);//feito isso nós mudamos as informações que desejamos e setamos o id "novo" para sobreescrever os dados
        return service.inserir(produto);//Ai salvamos
    }

    @DeleteMapping("/{id}")
        public void deletar(@PathVariable Long id){
            service.deletar(id);
    }

    @GetMapping("/buscar")
    public List<Produto> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }

}
