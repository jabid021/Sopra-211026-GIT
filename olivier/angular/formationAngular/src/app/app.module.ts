import { PersonnagesComponent } from './lotr/personnage/personnages/personnages.component';
import { ProduitComponent } from './produit/produit/produit.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
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
import { ListProduitComponent } from './exercice/produit/list-produit/list-produit.component';
import { DemoDirective } from './directives/demo.directive';
import { DisplayMessageDirective } from './directives/display-message.directive';
import { HomeComponent } from './home/home.component';
import { routes } from './routes';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { NavComponent } from './nav/nav.component';
import { ParametreComponent } from './parametre/parametre.component';
import { NavigationParLeCodeComponent } from './navigation-par-le-code/navigation-par-le-code.component';
import { LigneProduitComponent } from './exercice/produit/ligne-produit/ligne-produit.component';
import { DemoPipe } from './mesPipes/demo.pipe';
import { CompagnonsComponent } from './lotr/compagnons/compagnons.component';
import { EditCompagnonComponent } from './lotr/edit-compagnon/edit-compagnon.component';
import { VivantPipe } from './mesPipes/vivant.pipe';
import { EditPersonnageComponent } from './lotr/personnage/edit-personnage/edit-personnage.component';

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
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    ParametreComponent,
    NavigationParLeCodeComponent,
    LigneProduitComponent,
    DemoPipe,
    CompagnonsComponent,
    EditCompagnonComponent,
    PersonnagesComponent,
    VivantPipe,
    EditPersonnageComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
