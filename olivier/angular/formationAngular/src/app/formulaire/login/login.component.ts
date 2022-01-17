import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  error: boolean = false;
  constructor(private auth: AuthenticationService, private router: Router) {
    this.form = new FormGroup({
      login: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {}

  validate() {
    let login = this.form.controls['login'].value;
    let password = this.form.controls['password'].value;
    this.auth.login(login, password).subscribe(
      (ok) => {
        //authentifier
        localStorage.setItem('token', btoa(login + ':' + password));
        localStorage.setItem('login', login);
        this.router.navigate(['/home']);
      },
      (error) => {
        this.error = true;
      }
    );
  }
}
