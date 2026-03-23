import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Solicitacao {
  idSolicitacao: number;
  solicitante: string;
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
