import { CompagnonService } from 'src/app/services/compagnon.service';
import { Personnage } from './../model/personnage';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { ReactiveFormsModule } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class PersonnageService {
  private static URL: string = 'http://localhost:8080/lotr/api/personnage';

  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  getAll(): Observable<Personnage[]> {
    return this.http.get<Personnage[]>(PersonnageService.URL);
  }

  getById(id: number): Observable<Personnage> {
    return this.http.get<Personnage>(`${PersonnageService.URL}/${id}`);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${PersonnageService.URL}/${id}`, {
      headers: this.auth.headers,
    });
  }

  private formatPersonnageToJson(personnage: Personnage): Object {
    const p = {
      nom: personnage.nom,
      pv: personnage.pv,
      race: personnage.race,
      vivant: personnage.vivant,
    };
    if (!!personnage.familier && personnage.familier.id !== undefined) {
      Object.assign(p, { familier: { id: personnage.familier.id } });
    }
    if (!!personnage.id) {
      Object.assign(p, { id: personnage.id });
    }
    return p;
  }

  create(personnage: Personnage): Observable<Personnage> {
    return this.http.post<Personnage>(
      PersonnageService.URL,
      this.formatPersonnageToJson(personnage),
      {
        headers: this.auth.headers,
      }
    );
  }
  put(personnage: Personnage): Observable<Personnage> {
    return this.http.put<Personnage>(
      PersonnageService.URL + '/' + personnage.id,
      this.formatPersonnageToJson(personnage),
      {
        headers: this.auth.headers,
      }
    );
  }
}
