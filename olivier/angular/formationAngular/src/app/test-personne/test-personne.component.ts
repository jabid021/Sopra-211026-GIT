import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test-personne',
  templateUrl: './test-personne.component.html',
  styleUrls: ['./test-personne.component.css'],
})
export class TestPersonneComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {
    let olivier: Personne = new Personne('olivier');
    olivier.prenom = 'oooooo';
    console.log(olivier);
  }
}
