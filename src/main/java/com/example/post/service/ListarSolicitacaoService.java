package com.example.post.service;

import br.com.seuprojeto.soap.client.StatusSolicitacao;
import com.example.post.domain.StatusSolicitacaoEntity;
import com.example.post.domain.dto.AereoDTO;
import com.example.post.domain.dto.AereoSegmentoDTO;
import com.example.post.domain.dto.PassageiroDTO;
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

        SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO();

        solicitacaoDTO.setIdSolicitacao(entity.getIdSolicitacao());
        solicitacaoDTO.setSolicitante(entity.getSolicitante());

        solicitacaoDTO.setStatus(entity.getStatus().getDescricao());

        // Passageiros
        List<PassageiroDTO> passageiroDTOS = entity.getPassageiros()
                .stream()
                .map(p -> {
                    PassageiroDTO passageiroDTO = new PassageiroDTO();
                    passageiroDTO.setNome(p.getNome());
                    return passageiroDTO;
                })
                .collect(Collectors.toList());

        solicitacaoDTO.setPassageiros(passageiroDTOS);

        // Aereos
        List<AereoDTO> aereoDTOS = entity.getAereos()
                .stream()
                .map(a -> {
                    AereoDTO aereoDTO = new AereoDTO();
                    aereoDTO.setLocalizador(a.getLocalizador());
                    aereoDTO.setCia(a.getCia());

                    List<AereoSegmentoDTO> aereoSeguimentoDTOS = a.getSegmentos()
                            .stream()
                            .map(seg -> {
                                AereoSegmentoDTO aereoSegmentoDTO = new AereoSegmentoDTO();
                                aereoSegmentoDTO.setCidadeOrigem(seg.getCidadeOrigem());
                                aereoSegmentoDTO.setCidadeDestino(seg.getCidadeDestino());
                                aereoSegmentoDTO.setDataSaida(seg.getDataSaida());
                                aereoSegmentoDTO.setDataChegada(seg.getDataChegada());

                                return aereoSegmentoDTO;
                            })
                            .collect(Collectors.toList());

                    aereoDTO.setAereosSeguimentos(aereoSeguimentoDTOS);

                    return aereoDTO;
                })
                .collect(Collectors.toList());

        solicitacaoDTO.setAereos(aereoDTOS);




        return solicitacaoDTO;
    }


}
