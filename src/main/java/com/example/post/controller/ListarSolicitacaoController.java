package com.example.post.controller;

import com.example.post.domain.dto.SolicitacaoDTO;
import com.example.post.service.ListarSolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/listar-solicitacoes")
public class ListarSolicitacaoController {

    @Autowired
    private ListarSolicitacaoService listarSolicitacaoService;

    @GetMapping
    public List<SolicitacaoDTO> listar() {
        return listarSolicitacaoService.listarsolicitacoes();
    }
}
