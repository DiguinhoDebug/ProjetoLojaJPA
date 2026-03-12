package org.example.lojajpa.repository;

import org.example.lojajpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { //Um dos principios da Poo, uma base para ser feito algo(no caso ativar o service e comunicar com o BD)

} //Tandannn agora o repository faz a comunicação de informações, simples
