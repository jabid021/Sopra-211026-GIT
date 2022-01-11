import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-candidat,[candidat]',
  templateUrl: './candidat.component.html',
  styleUrls: ['./candidat.component.css'],
})
export class CandidatComponent implements OnInit {
  @Input()
  nom: string = '';
  @Output()
  voteRecu: EventEmitter<Object> = new EventEmitter();
  vote: number = 0;

  constructor() {}

  ngOnInit(): void {}

  voter() {
    this.vote++;
    this.voteRecu.emit({ nom: this.nom, vote: this.vote });
  }
}
