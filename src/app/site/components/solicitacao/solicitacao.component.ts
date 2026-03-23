import { Component, OnInit } from '@angular/core';
import { Solicitacao, SolicitacaoService } from '../../services/solicitacao.service';

@Component({
  selector: 'app-solicitacao',
  templateUrl: './solicitacao.component.html',
  styleUrls: ['./solicitacao.component.css']
})
export class SolicitacaoComponent {

  solicitacoes: Solicitacao[] = [];

  constructor(private service: SolicitacaoService) { }

  buscarSolicitacoes(): void {
    this.service.getSolicitacoes()
    .subscribe(data => {
      console.log(data);
      this.solicitacoes = data;
    });
  }

}
