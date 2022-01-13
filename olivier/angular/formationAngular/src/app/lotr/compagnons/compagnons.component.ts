import { Compagnon } from './../../model/compagnon';
import { Component, OnInit } from '@angular/core';
import { CompagnonService } from 'src/app/services/compagnon.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-compagnons',
  templateUrl: './compagnons.component.html',
  styleUrls: ['./compagnons.component.css'],
})
export class CompagnonsComponent implements OnInit {
  //compagnons: Compagnon[] = [];
  compagnons: Observable<Compagnon[]> | null = null;
  constructor(private compagnonService: CompagnonService) {}

  ngOnInit(): void {
    // this.compagnonService.getAll().subscribe((result) => {
    //   this.compagnons = result;
    // });

    this.compagnons = this.compagnonService.getAll();
  }

  delete(id: number) {
    this.compagnonService.delete(id).subscribe((ok) => {
      this.compagnons = this.compagnonService.getAll();
    });
  }
}
