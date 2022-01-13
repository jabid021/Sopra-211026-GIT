import { Compagnon } from './../model/compagnon';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompagnonService {
  private static URL: string = 'http://localhost:8080/lotr/api/compagnon';
  constructor(private http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('olivier:olivier'),
    });
  }

  public getAll(): Observable<Compagnon[]> {
    return this.http.get<Compagnon[]>(CompagnonService.URL, {
      headers: this.getHeaders(),
    });
  }

  public getById(id: number): Observable<Compagnon> {
    return this.http.get<Compagnon>(CompagnonService.URL + '/' + id, {
      headers: this.getHeaders(),
    });
  }

  public update(compagnon: Compagnon): Observable<Compagnon> {
    return this.http.put<Compagnon>(
      CompagnonService.URL + '/' + compagnon.id,
      compagnon,
      {
        headers: this.getHeaders(),
      }
    );
  }

  public create(compagnon: Compagnon): Observable<Compagnon> {
    const o = {
      nom: compagnon.nom,
    };
    return this.http.post<Compagnon>(CompagnonService.URL, o, {
      headers: this.getHeaders(),
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(CompagnonService.URL + '/' + id, {
      headers: this.getHeaders(),
    });
  }
}
