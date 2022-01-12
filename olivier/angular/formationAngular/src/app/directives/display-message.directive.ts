import { Directive, ElementRef, Renderer2, Input, OnInit } from '@angular/core';

@Directive({
  selector: '[displayMessage]',
})
export class DisplayMessageDirective implements OnInit {
  @Input()
  message: string = '';

  constructor(private elemRef: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
    const p = this.renderer.createElement('p');
    this.renderer.setProperty(p, 'innerHTML', this.message);
    this.renderer.appendChild(this.elemRef.nativeElement, p);
  }
}
