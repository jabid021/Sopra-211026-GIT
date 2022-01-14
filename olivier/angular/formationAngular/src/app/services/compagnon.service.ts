import { AuthenticationService } from './authentication.service';
import { Compagnon } from './../model/compagnon';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompagnonService {
  private static URL: string = 'http://localhost:8080/lotr/api/compagnon';
  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  public getAll(): Observable<Compagnon[]> {
    return this.http.get<Compagnon[]>(CompagnonService.URL, {
      headers: this.auth.headers,
    });
  }

  public getLibre(): Observable<Compagnon[]> {
    return this.http.get<Compagnon[]>(`${CompagnonService.URL}/libre`, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Compagnon> {
    return this.http.get<Compagnon>(CompagnonService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(compagnon: Compagnon): Observable<Compagnon> {
    return this.http.put<Compagnon>(
      CompagnonService.URL + '/' + compagnon.id,
      compagnon,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(compagnon: Compagnon): Observable<Compagnon> {
    const o = {
      nom: compagnon.nom,
    };
    return this.http.post<Compagnon>(CompagnonService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(CompagnonService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
