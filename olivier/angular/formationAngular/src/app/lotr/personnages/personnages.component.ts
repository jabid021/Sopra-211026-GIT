import { PersonnageService } from './../../services/personnage.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css'],
})
export class PersonnagesComponent implements OnInit {
  personnages: any;

  constructor(private personnageService: PersonnageService) {}

  ngOnInit(): void {
    this.personnageService.getAll().subscribe((result) => {
      this.personnages = result;
    });
  }
}
