package org.example.lojajpa.dto;
/*
Uma classe imutável que serve apenas para transferência de dados (Tipo Record com propriedades específicas)
Tipo um filtro, ele pega apenas dados específicos para o POST e GET (Dados específicos do Banco)
como se tivesse fazendo compras no seu sistema e pega apenas variáveis que você quer em vez de pegar tudo
DATA TRANSFER OBJECT
Interessante e necessário já que o GET traria dados sensíveis dos usuários, então daria B.O judicial e tals
*/

//Dentro dos parenteses vai o que você quer que o DTO "Compre"/pegue na consulta/filtro, o que vai ser usado
//Não há necessidade de criar Getter, pois já é criado automáticamente (e setter nem dá, pois a classe é imutável)

//ANOTAÇÔES "OFF TOPIC"

/*
Bean é o objeto gerenciado pelo Spring
DTO é objeto para transportar dados
Record é a forma curta de criar DTO
Entity é a tabela do banco
*/
public record ProdutoDTO(String nome, double preco) {
}
