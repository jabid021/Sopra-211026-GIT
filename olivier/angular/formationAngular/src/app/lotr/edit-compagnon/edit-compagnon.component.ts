import { ActivatedRoute, Router } from '@angular/router';
import { Compagnon } from './../../model/compagnon';
import { Component, OnInit } from '@angular/core';
import { CompagnonService } from 'src/app/services/compagnon.service';

@Component({
  selector: 'app-edit-compagnon',
  templateUrl: './edit-compagnon.component.html',
  styleUrls: ['./edit-compagnon.component.css'],
})
export class EditCompagnonComponent implements OnInit {
  compagnon: Compagnon = new Compagnon();

  constructor(
    private activatedRoute: ActivatedRoute,
    private compagnonService: CompagnonService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.compagnonService.getById(params['id']).subscribe((result) => {
          this.compagnon = result;
        });
      }
    });
  }

  save() {
    if (!!this.compagnon.id) {
      this.compagnonService.update(this.compagnon).subscribe((ok) => {
        this.router.navigate(['/compagnon']);
      });
    } else {
      this.compagnonService.create(this.compagnon).subscribe((ok) => {
        this.router.navigate(['/compagnon']);
      });
    }
  }
}
