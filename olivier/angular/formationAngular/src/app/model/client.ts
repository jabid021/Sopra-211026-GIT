import { Produit } from './produit';
import { Personne } from './personne';
export class Client extends Personne {
  private _produits: Produit[] = [];

  public constructor(_prenom?: string, _nom?: string, private _ca: number = 0) {
    super(_prenom, _nom);
  }

  public get ca(): number {
    return this._ca;
  }

  public set ca(value: number) {
    this._ca = value;
  }

  public get produits(): Produit[] {
    return this._produits;
  }
}
