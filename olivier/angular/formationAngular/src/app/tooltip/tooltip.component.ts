import { Component, OnInit, Input, HostListener } from '@angular/core';

@Component({
  selector: 'app-tooltip',
  templateUrl: './tooltip.component.html',
  styleUrls: ['./tooltip.component.css'],
})
export class TooltipComponent implements OnInit {
  @Input('tooltip')
  message: string = '';

  visible: boolean = false;
  constructor() {}

  ngOnInit(): void {}

  @HostListener('mouseenter')
  showTooltip() {
    this.visible = true;
  }

  @HostListener('mouseleave')
  hideTooltip() {
    this.visible = false;
  }
}
