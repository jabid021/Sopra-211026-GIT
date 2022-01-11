import { Produit } from '../../model/produit';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent implements OnInit {
  produit: Produit = new Produit();

  @Output()
  produitReady: EventEmitter<Produit> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  validation() {
    this.produitReady.emit(new Produit(this.produit.nom, this.produit.prix));
    this.produit=new Produit();
  }
}
