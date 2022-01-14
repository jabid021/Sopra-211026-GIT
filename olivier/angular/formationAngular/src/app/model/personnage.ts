import { Compagnon } from './compagnon';
import { Race } from './race';
export class Personnage {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _pv?: number,
    private _race?: Race,
    private _vivant?: boolean,
    private _familier?: Compagnon
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get pv(): number | undefined {
    return this._pv;
  }

  public set pv(value: number | undefined) {
    this._pv = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get race(): Race | undefined {
    return this._race;
  }

  public set race(value: Race | undefined) {
    this._race = value;
  }

  public get vivant(): boolean | undefined {
    return this._vivant;
  }

  public set vivant(value: boolean | undefined) {
    this._vivant = value;
  }

  public get familier(): Compagnon | undefined {
    return this._familier;
  }

  public set familier(value: Compagnon | undefined) {
    this._familier = value;
  }
}
