package com.example.post.service;

import com.example.post.domain.dto.SolicitacaoDTO;
import com.example.post.domain.entity.SolicitacaoEntity;
import com.example.post.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarSolicitacaoService {

    @Autowired
    private SolicitacaoRepository repository;

    public List<SolicitacaoDTO> listarsolicitacoes(){

        List<SolicitacaoEntity> entities = repository.findAll();

        return entities.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private SolicitacaoDTO converterParaDTO(SolicitacaoEntity entity) {

        SolicitacaoDTO dto = new SolicitacaoDTO();

        dto.setIdSolicitacao(entity.getIdSolicitacao());
        dto.setSolicitante(entity.getSolicitante());

        return dto;
    }

}
