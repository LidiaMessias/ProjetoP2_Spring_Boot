package com.projeto.projetop2.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class JogosDAO {
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirJogo(Jogos jogo) {
        String sql = "INSERT INTO jogos(nome, estado, preco, console, imagem) VALUES (?, ?, ?, ?, ?)";
        jdbc.update(sql, jogo.getNome(), jogo.getEstado(), jogo.getPreco(), jogo.getConsole(), jogo.getImagem());
    }
}
