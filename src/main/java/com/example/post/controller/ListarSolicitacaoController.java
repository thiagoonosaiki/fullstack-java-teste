package com.example.post.controller;

import com.example.post.domain.dto.SolicitacaoDTO;
import com.example.post.service.ListarSolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/listar-solicitacoes")
public class ListarSolicitacaoController {

    @Autowired
    private ListarSolicitacaoService listarSolicitacaoService;

    @GetMapping
    public Page<SolicitacaoDTO> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return listarSolicitacaoService.solicitacaoDTOPage(page, size);
    }
//    {
//        return listarSolicitacaoService.listarsolicitacoes();
//    }
}
