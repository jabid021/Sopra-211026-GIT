import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-parametre',
  templateUrl: './parametre.component.html',
  styleUrls: ['./parametre.component.css'],
})
export class ParametreComponent implements OnInit {
  prenom: string = '';

  constructor(private activatedRouted: ActivatedRoute) {}

  ngOnInit(): void {
    // this.prenom = this.activatedRouted.snapshot.params['prenom'];

    //assynchrome
    this.activatedRouted.params.subscribe((params) => {
      this.prenom = params['prenom'];
    });
    //execution avant la fin subscribe
    // console.log(this.prenom);
  }
}
