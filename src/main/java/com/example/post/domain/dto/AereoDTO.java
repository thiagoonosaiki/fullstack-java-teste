package com.example.post.domain.dto;

import java.util.List;

public class AereoDTO {
    private Long id;
    private String cia;
    private String localizador;
    private List<AereoSegmentoDTO> aereosSegmentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCia() {
        return cia;
    }

    public void setCia(String cia) {
        this.cia = cia;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public List<AereoSegmentoDTO> getAereosSeguimentos() {
        return aereosSegmentos;
    }

    public void setAereosSeguimentos(List<AereoSegmentoDTO> aereosSeguimentos) {
        this.aereosSegmentos = aereosSeguimentos;
    }
}
