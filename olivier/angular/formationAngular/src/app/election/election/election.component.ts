import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-election',
  templateUrl: './election.component.html',
  styleUrls: ['./election.component.css'],
})
export class ElectionComponent implements OnInit {
  maxVote: number = 0;
  enTete: string = '';

  constructor() {}

  ngOnInit(): void {}

  traitmentVoteRecu(o: any) {
    if (o.vote > this.maxVote) {
      this.maxVote = o.vote;
      this.enTete = o.nom;
    }
  }
}
