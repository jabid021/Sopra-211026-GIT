import { Produit } from './model/produit';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';

  getProduit(): Produit {
    return new Produit('tele', 10000);
  }
}
