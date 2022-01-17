import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidator {
  public static pasOlivier(control: AbstractControl): ValidationErrors | null {
    return control.value == 'olivier' ? { pasolivier: true } : null;
  }

  public static pasTexte(texte: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == texte ? { pastexte: true } : null;
    };
  }
}
