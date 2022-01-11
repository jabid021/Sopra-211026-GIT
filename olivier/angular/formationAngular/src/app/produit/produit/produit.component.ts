import { Produit } from './../../model/produit';

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

  clickInput() {
    console.log("click sur l'input");
  }

  getProduit(produitRecu: Produit) {
    this.produit = produitRecu;
  }
}
