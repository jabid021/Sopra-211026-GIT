import { CustomValidator } from './../../validators/custom-validator';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-formulaire-pilote-par-code',
  templateUrl: './formulaire-pilote-par-code.component.html',
  styleUrls: ['./formulaire-pilote-par-code.component.css'],
})
export class FormulairePiloteParCodeComponent implements OnInit {
  monForm: FormGroup;

  constructor(private fb: FormBuilder) {
    //this.monForm=this.fb.group({});
    this.monForm = new FormGroup({
      prenomCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
        CustomValidator.pasOlivier,
        CustomValidator.pasTexte('antoine'),
      ]),
      nomCtrl: new FormControl('default'),
      group1: new FormGroup(
        {
          password: new FormControl('', Validators.required),
          confirm: new FormControl(''),
        },
        this.checkEquals
      ),
    });
  }

  checkEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    if (formGroup.controls['password'].pristine) return null;
    return formGroup.controls['password'].value !=
      formGroup.controls['confirm'].value
      ? { checkequals: true }
      : null;
  }

  ngOnInit(): void {}

  validate() {
    console.log(this.monForm.controls['monCtrl']);
  }
}
