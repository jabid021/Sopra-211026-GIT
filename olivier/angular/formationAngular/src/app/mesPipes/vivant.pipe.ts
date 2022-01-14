import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'vivant',
})
export class VivantPipe implements PipeTransform {
  transform(value: boolean, ...args: unknown[]): unknown {
    return value ? 'vivant' : 'mort';
  }
}
