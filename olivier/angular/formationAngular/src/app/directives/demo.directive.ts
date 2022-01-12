import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[rouge]',
})
export class DemoDirective {
  constructor(private elemRef: ElementRef, private renderer: Renderer2) {
    console.log(this.elemRef);
    this.renderer.setStyle(this.elemRef.nativeElement, 'color', 'red');
  }
}
