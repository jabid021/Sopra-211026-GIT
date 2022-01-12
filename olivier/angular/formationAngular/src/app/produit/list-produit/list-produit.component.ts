import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = [
    new Produit('tele', 500),
    new Produit('telephone', 0),
    new Produit('produit', -1),
  ];

  filtre: string = '';

  constructor() {}

  ngOnInit(): void {}

  getInfo(prix: number): string {
    if (prix < 0) {
      return 'negatif';
    } else if (prix == 0) {
      return 'neutre';
    } else {
      return 'positif';
    }
  }

  recupProduit(produit: Produit) {
    this.produits.push(produit);
  }

  get produitsFiltre(): Produit[] {
    // return this.produits.filter((p) => {
    //   return p.nom?.indexOf(this.filtre) !== -1;
    // });
    return this.produits.filter((p) => p.nom?.indexOf(this.filtre) !== -1);
  }
}
