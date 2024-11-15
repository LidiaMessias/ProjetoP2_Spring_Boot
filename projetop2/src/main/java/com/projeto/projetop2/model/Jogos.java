package com.projeto.projetop2.model;

// POJO - Plain old Java Object
public class Jogos {

    private int id;
    private String nome, estado, console, imagem;
    private double preco;

    // Sobrecarga
    // Para cadastrar um registro
    public Jogos() {

    }

    // Para atualização de registro
    public Jogos(int id, String nome, String estado, String console, double preco, String imagem) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.console = console;
        this.preco = preco;
        this.imagem = imagem;
    }

    // Para inserir o registro
    public Jogos(String nome, String estado, String console, double preco, String imagem) {
        this.nome = nome;
        this.estado = estado;
        this.console = console;
        this.preco = preco;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
