import { Component, OnInit } from "@angular/core";
import {
  Solicitacao,
  SolicitacaoService,
} from "../../services/solicitacao.service";

@Component({
  selector: "app-solicitacao",
  templateUrl: "./solicitacao.component.html",
  styleUrls: ["./solicitacao.component.css"],
})
export class SolicitacaoComponent {
  solicitacoes: Solicitacao[] = [];

  constructor(private service: SolicitacaoService) {}

  paginaAtual = 0;
  tamanhoPagina = 5;
  totalPaginas = 0;

  buscarSolicitacoes() {
    this.service
      .getSolicitacoes(this.paginaAtual, this.tamanhoPagina)
      .subscribe((res) => {
        this.solicitacoes = res.content;
        this.totalPaginas = res.totalPages;
        this.paginaAtual = res.number;
      });
  }

  proximaPagina() {
    if (this.paginaAtual < this.totalPaginas - 1) {
      this.paginaAtual++;
      this.buscarSolicitacoes();
    }
  }

  paginaAnterior() {
    if (this.paginaAtual > 0) {
      this.paginaAtual--;
      this.buscarSolicitacoes();
    }
  }

  // buscarSolicitacoes(): void {
  //   this.service.getSolicitacoes()
  //   .subscribe(data => {
  //     console.log(data);
  //     this.solicitacoes = data;
  //   });
  // }
}
