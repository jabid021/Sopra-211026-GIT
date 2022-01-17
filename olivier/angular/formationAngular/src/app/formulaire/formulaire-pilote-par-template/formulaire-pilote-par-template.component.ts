import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-formulaire-pilote-par-template',
  templateUrl: './formulaire-pilote-par-template.component.html',
  styleUrls: ['./formulaire-pilote-par-template.component.css'],
})
export class FormulairePiloteParTemplateComponent implements OnInit {
  texte: string = '';

  constructor() {}

  ngOnInit(): void {}

  validate(monForm: any) {
    console.log(monForm['controls']);
    console.log(monForm.controls['texte'].value);
  }
}
