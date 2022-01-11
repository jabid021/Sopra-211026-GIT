import { Produit } from './../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css'],
})
export class DemoComponent {
  @Input()
  parametre: string = '';
  @Input('autre-param')
  param2: string = '';
  @Input()
  produit: Produit = new Produit();
}
