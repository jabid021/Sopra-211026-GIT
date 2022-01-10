import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-personne',
  templateUrl: './test-personne.component.html',
  styleUrls: ['./test-personne.component.css'],
})
export class TestPersonneComponent implements OnInit {
  message: string = 'hello';
  // personne: Personne = new Personne('olivier', 'gozlan');
  couleur: string = 'yellow';
  personne = { prenom: 'olivier', nom: 'gozlan' };

  constructor() {}

  ngOnInit(): void {}

  getPersonne(): Personne {
    return new Personne('toto');
  }

  displayAlert() {
    alert('une alert');
  }
}
