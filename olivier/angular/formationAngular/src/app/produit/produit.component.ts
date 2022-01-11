import { Produit } from './../model/produit';
import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit,[produit-directive]',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  click() {
    this.produit.nom = 'mmmmmm';
  }

  clickInput() {
    console.log("click sur l'input");
  }
}
