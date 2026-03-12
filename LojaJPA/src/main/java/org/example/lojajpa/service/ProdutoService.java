package org.example.lojajpa.service;


import org.example.lojajpa.model.Produto;
import org.example.lojajpa.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository; //Criamos uma váriavel(Constante) com valor que não pode ser mudado, tipo ProdutoRepository, isso busca as configurações do JPA

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public Produto inserir(Produto produto){//Injeção de dependência, o Spring e JPA cuidam dos nossos objetos
        return repository.save(produto); //Repository trás os métodos do JPA, Save, Delete, Find. O Service implementa
    }

    public Produto buscar(Long id){
        return repository.findById(id).orElse(null); //Procura o objeto por Id, caso contrário retorna nulo;
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public void deletar(Long id){
        repository.deleteById(id); //Não precisa de return pq é um void
    }
}
