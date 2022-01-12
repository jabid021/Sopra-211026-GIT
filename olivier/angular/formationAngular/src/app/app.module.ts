import { ProduitComponent } from './produit/produit/produit.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './demo/demo.component';
import { TestPersonneComponent } from './test-personne/test-personne.component';
import { SelectComponent } from './select/select.component';

import { DisplayProduitComponent } from './produit/display-produit/display-produit.component';
import { TooltipComponent } from './tooltip/tooltip.component';
import { FormProduitComponent } from './produit/form-produit/form-produit.component';
import { CandidatComponent } from './election/candidat/candidat.component';
import { ElectionComponent } from './election/election/election.component';
import { ListProduitComponent } from './produit/list-produit/list-produit.component';
import { DemoDirective } from './directives/demo.directive';
import { DisplayMessageDirective } from './directives/display-message.directive';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    TestPersonneComponent,
    SelectComponent,
    ProduitComponent,
    DisplayProduitComponent,
    TooltipComponent,
    FormProduitComponent,
    CandidatComponent,
    ElectionComponent,
    ListProduitComponent,
    DemoDirective,
    DisplayMessageDirective,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
