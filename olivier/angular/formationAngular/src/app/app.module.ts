import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './demo/demo.component';
import { TestPersonneComponent } from './test-personne/test-personne.component';
import { SelectComponent } from './select/select.component';
import { ProduitComponent } from './produit/produit.component';

@NgModule({
  declarations: [AppComponent, DemoComponent, TestPersonneComponent, SelectComponent, ProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
