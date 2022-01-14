import { LoginComponent } from './formulaire/login/login.component';
import { InscriptionComponent } from './formulaire/inscription/inscription.component';
import { FormulairePiloteParCodeComponent } from './formulaire/formulaire-pilote-par-code/formulaire-pilote-par-code.component';
import { EditPersonnageComponent } from './lotr/personnage/edit-personnage/edit-personnage.component';
import { EditCompagnonComponent } from './lotr/edit-compagnon/edit-compagnon.component';
import { CompagnonsComponent } from './lotr/compagnons/compagnons.component';
import { NavigationParLeCodeComponent } from './navigation-par-le-code/navigation-par-le-code.component';
import { ParametreComponent } from './parametre/parametre.component';
import { ListProduitComponent } from './exercice/produit/list-produit/list-produit.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { PersonnagesComponent } from './lotr/personnage/personnages/personnages.component';
import { FormulairePiloteParTemplateComponent } from './formulaire/formulaire-pilote-par-template/formulaire-pilote-par-template.component';
import { AuthenticationService } from './services/authentication.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListProduitComponent },
  { path: 'parametre/:prenom', component: ParametreComponent },
  { path: 'nav', component: NavigationParLeCodeComponent },
  { path: 'formulaire', component: FormulairePiloteParCodeComponent },
  { path: 'inscription', component: InscriptionComponent },
  {
    path: 'personnage',
    component: PersonnagesComponent,
  },
  {
    path: 'personnage/edit',
    component: EditPersonnageComponent,
    canActivate: [AuthenticationService],
  },
  {
    path: 'personnage/edit/:id',
    component: EditPersonnageComponent,
    canActivate: [AuthenticationService],
  },
  {
    path: 'compagnon',
    component: CompagnonsComponent,
    canActivate: [AuthenticationService],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'compagnon/edit',
    component: EditCompagnonComponent,
    canActivate: [AuthenticationService],
  },
  {
    path: 'compagnon/edit/:id',
    component: EditCompagnonComponent,
    canActivate: [AuthenticationService],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
