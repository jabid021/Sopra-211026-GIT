import { Compagnon } from './../../../model/compagnon';
import { CompagnonService } from 'src/app/services/compagnon.service';
import { Race } from './../../../model/race';
import { PersonnageService } from './../../../services/personnage.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Personnage } from 'src/app/model/personnage';

@Component({
  selector: 'app-edit-personnage',
  templateUrl: './edit-personnage.component.html',
  styleUrls: ['./edit-personnage.component.css'],
})
export class EditPersonnageComponent implements OnInit {
  personnage: Personnage = new Personnage();
  races = Race;
  compagnons: Compagnon[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private personnageService: PersonnageService,
    private router: Router,
    private compagnonService: CompagnonService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.personnageService.getById(params['id']).subscribe((result) => {
          this.personnage = result;
        });
      }
    });
    this.compagnonService.getAll().subscribe((result) => {
      this.compagnons = result;
    });
  }

  byId(obj1: Compagnon, obj2: Compagnon) {
    if (!!obj2 && !!obj1) return obj1.id == obj2.id;
    if (obj1 == obj2) return true;
    return false;
  }

  save() {
    if (!!this.personnage.id) {
      this.personnageService.put(this.personnage).subscribe((ok) => {
        this.router.navigate(['/personnage']);
      });
    } else {
      this.personnageService.create(this.personnage).subscribe((ok) => {
        this.router.navigate(['/personnage']);
      });
    }
  }
}
