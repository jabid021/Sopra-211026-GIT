import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PersonnageService {
  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get('http://localhost:8080/lotr/api/personnage');
  }
}
