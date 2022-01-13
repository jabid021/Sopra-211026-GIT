import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'monPipe',
})
export class DemoPipe implements PipeTransform {
  transform(value: number, ...args: unknown[]): string {
    if (value < 0) {
      return 'negatif';
    } else if (value == 0) {
      return 'neutre';
    }
    return 'positif';
  }
}
