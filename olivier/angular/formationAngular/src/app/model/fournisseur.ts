import { Personne } from './personne';
export class Fournisseur extends Personne {
  public constructor(prenom?: string, nom?: string, private _societe?: string) {
    super(prenom, nom);
  }

  public get societe(): string | undefined {
    return this._societe;
  }

  public set societe(value: string | undefined) {
    this._societe = value;
  }
}
