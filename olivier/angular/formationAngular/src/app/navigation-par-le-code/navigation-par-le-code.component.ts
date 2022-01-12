import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation-par-le-code',
  templateUrl: './navigation-par-le-code.component.html',
  styleUrls: ['./navigation-par-le-code.component.css']
})
export class NavigationParLeCodeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  goHome(){
    //traitement
    this.router.navigate(['/home']);
  }

}
