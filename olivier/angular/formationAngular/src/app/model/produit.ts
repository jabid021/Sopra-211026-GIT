import { Fournisseur } from './fournisseur';
export class Produit {
  public constructor(
    private _nom?: string,
    private _prix: number=0,
    private _fournisseur?: Fournisseur
  ) {}

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get prix(): number {
    return this._prix;
  }

  public set prix(value: number) {
    this._prix = value;
  }
  public get fournisseur(): Fournisseur | undefined {
    return this._fournisseur;
  }

  public set fournisseur(value: Fournisseur | undefined) {
    this._fournisseur = value;
  }
}
