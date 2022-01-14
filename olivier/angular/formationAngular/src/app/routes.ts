import { EditPersonnageComponent } from './lotr/personnage/edit-personnage/edit-personnage.component';
import { EditCompagnonComponent } from './lotr/edit-compagnon/edit-compagnon.component';
import { CompagnonsComponent } from './lotr/compagnons/compagnons.component';
import { NavigationParLeCodeComponent } from './navigation-par-le-code/navigation-par-le-code.component';
import { ParametreComponent } from './parametre/parametre.component';
import { ListProduitComponent } from './exercice/produit/list-produit/list-produit.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { PersonnagesComponent } from './lotr/personnage/personnages/personnages.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListProduitComponent },
  { path: 'parametre/:prenom', component: ParametreComponent },
  { path: 'nav', component: NavigationParLeCodeComponent },
  { path: 'personnage', component: PersonnagesComponent },
  { path: 'personnage/edit', component: EditPersonnageComponent },
  { path: 'personnage/edit/:id', component: EditPersonnageComponent },
  { path: 'compagnon', component: CompagnonsComponent },
  { path: 'compagnon/edit', component: EditCompagnonComponent },
  { path: 'compagnon/edit/:id', component: EditCompagnonComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
