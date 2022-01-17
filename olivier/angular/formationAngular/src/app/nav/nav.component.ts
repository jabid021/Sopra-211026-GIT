import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }

  get login(): string | null {
    return localStorage.getItem('login');
  }
}
