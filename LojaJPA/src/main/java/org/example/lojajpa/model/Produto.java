package org.example.lojajpa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity //entidade relacinamento tabela
@Getter //Criou Getter pelo lombok
@Setter //Criou Setter pelo lombok
public class Produto {

    @Id //declara q é um id, torna ele uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //precisa de um parametro pra ser gerado o valor sozinho (incrementando)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio!") //Para String, o resto é NotNull
    private String nome;
    @NotNull(message = "Preço não pode ser >0/Vazio!")
    @Positive(message = "O valor tem que ser positivo!") //Acho que da pra entender o que faz né? tem que ser positivo
    private Double preco;

    public Produto(){}

}
