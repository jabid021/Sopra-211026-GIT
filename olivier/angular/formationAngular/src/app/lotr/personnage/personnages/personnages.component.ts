import { PersonnageService } from './../../../services/personnage.service';
import { Component, OnInit } from '@angular/core';
import { Personnage } from 'src/app/model/personnage';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css'],
})
export class PersonnagesComponent implements OnInit {
  personnages: Personnage[] = [];

  constructor(private personnageService: PersonnageService) {}

  ngOnInit(): void {
    this.initPersonnages();
  }

  initPersonnages() {
    this.personnageService.getAll().subscribe((result) => {
      this.personnages = result;
    });
  }

  delete(id: number) {
    this.personnageService.delete(id).subscribe((ok) => {
      this.initPersonnages();
    });
  }
}
