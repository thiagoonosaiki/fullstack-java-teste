package com.example.post.domain.dto;

import br.com.seuprojeto.soap.client.StatusSolicitacao;

import java.util.List;

public class SolicitacaoDTO {

    private int idSolicitacao;
    private String solicitante;
    private String status;

    private List<PassageiroDTO> passageiros;
    private List<AereoDTO> aereos;


    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PassageiroDTO> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<PassageiroDTO> passageiros) {
        this.passageiros = passageiros;
    }

    public List<AereoDTO> getAereos() {
        return aereos;
    }

    public void setAereos(List<AereoDTO> aereos) {
        this.aereos = aereos;
    }

}
