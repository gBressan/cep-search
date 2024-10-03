package br.com.convertcep.models;

public record Adress(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String regiao) {
}
