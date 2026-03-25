import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface AereoSegmento {
  cidadeOrigem: string;
  cidadeDestino: string;
}

export interface Aereo {
  cia: string;
  localizador: string;
  aereosSegmentos: AereoSegmento[];
}

export interface Passageiro {
  nome: string;
}
  
export interface Solicitacao {
  idSolicitacao: number;
  status: string;
  solicitante: string;
  passageiros: Passageiro[];
  aereos: Aereo[];
}


@Injectable({
  providedIn: 'root'
})
export class SolicitacaoService {

  private apiUrl = 'http://localhost:8080/listar-solicitacoes';

  constructor(private http: HttpClient) { }

  getSolicitacoes(): Observable<Solicitacao[]> {
    return this.http.get<Solicitacao[]>(this.apiUrl)
  }
}
