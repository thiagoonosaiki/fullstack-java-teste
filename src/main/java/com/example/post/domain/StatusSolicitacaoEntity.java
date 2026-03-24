package com.example.post.domain;

import br.com.seuprojeto.soap.client.StatusSolicitacao;

/**
 * Enumeração que representa os possíveis status
 * de uma solciitação do dóminio da aplicação.
 */
public enum StatusSolicitacaoEntity {

        CONCLUIDA("Concluído"),
        CANCELADA("Cancelada"),
        PENDENTE_APROVACAO("Pendente-Aprovação");

        private String descricao;

        StatusSolicitacaoEntity(String descricao) {
                this.descricao = descricao;
        }

        public String getDescricao() {
                return descricao;
        }
}
