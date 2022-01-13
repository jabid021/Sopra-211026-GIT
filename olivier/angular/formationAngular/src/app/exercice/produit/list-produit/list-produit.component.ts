import { produitsGlobal } from './../../../produits';
import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';
import { compileFactoryFunction } from '@angular/compiler';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = produitsGlobal;
  visible: boolean = false;
  constructor() {}

  ngOnInit(): void {}

  displayForm() {
    this.visible = true;
  }
  hideForm() {
    this.visible = false;
  }

  save(produit: Produit) {
    this.produits.push(produit);
    this.hideForm();
  }
}
