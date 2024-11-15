package com.projeto.projetop2.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projeto.projetop2.model.Jogos;
import com.projeto.projetop2.model.JogosService;

@Controller
public class CadastroJogosController {

    @Autowired
    ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastroJogos")
    public String cadastroJogos(Model model) {
        Jogos jogo = new Jogos();
        model.addAttribute("jogos", jogo);
        return "cadastroJogos";
    }  

    /* 
    @PostMapping("/cadastroJogos")
    public String sucesso(@ModelAttribute Jogos jogo) {
        JogosService js = context.getBean(JogosService.class);
        js.inserirJogo(jogo);
        return "sucesso";
    }  */

    @PostMapping("/cadastroJogos")
    public String sucesso(@ModelAttribute Jogos jogo, @RequestParam("imagem") MultipartFile imagem) throws IOException {
        // Diretório onde os arquivos serão salvos
        String uploadDir = "uploadimages/";
        // Nome do arquivo (garantindo que seja único, adicionando um timestamp)
        String nomeArquivo = System.currentTimeMillis() + "_" + imagem.getOriginalFilename();
        // Caminho completo do arquivo
        Path caminhoArquivo = Paths.get(uploadDir, nomeArquivo);
        // Salvar o arquivo no diretório especificado
        Files.createDirectories(caminhoArquivo.getParent()); // Garante que a pasta exista
        imagem.transferTo(caminhoArquivo.toFile());
        // Atualiza o caminho da imagem no objeto `Jogos`
        jogo.setImagem(caminhoArquivo.toString());

        JogosService js = context.getBean(JogosService.class);
        js.inserirJogo(jogo);
        return "sucesso";
    } 
}
