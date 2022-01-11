import { Produit } from './../model/produit';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent implements OnInit {
  @Input('produitAAfficher')
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}
}
