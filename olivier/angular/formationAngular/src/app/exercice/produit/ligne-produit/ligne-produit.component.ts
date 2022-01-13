import { Produit } from './../../../model/produit';
import { Component, Input, OnInit } from '@angular/core';
import { produitsGlobal } from 'src/app/produits';

@Component({
  selector: '[app-ligne-produit]',
  templateUrl: './ligne-produit.component.html',
  styleUrls: ['./ligne-produit.component.css'],
})
export class LigneProduitComponent implements OnInit {
  @Input('produit')
  produitRecu: Produit = new Produit();
  @Input()
  index: number = 0;
  edition: boolean = true;
  produit: Produit = new Produit();
  constructor() {}

  ngOnInit(): void {
    this.produit.nom = this.produitRecu.nom;
    this.produit.prix = this.produitRecu.prix;
  }
  delete(index: number) {
    produitsGlobal.splice(index, 1);
  }

  changeMode() {
    this.edition = !this.edition;
  }

  save() {
    produitsGlobal[this.index] = this.produit;
    this.changeMode();
  }

  cancel() {
    this.produit = this.produitRecu;
    this.changeMode();
  }
}
