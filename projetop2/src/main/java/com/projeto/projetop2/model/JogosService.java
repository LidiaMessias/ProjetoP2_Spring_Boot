package com.projeto.projetop2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogosService {

    @Autowired
    JogosDAO jdao;

    public void inserirJogo(Jogos jogo) {
        jdao.inserirJogo(jogo);
    }
}
