import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {
    console.log('instanciation du service');
  }

  sayHello() {
    console.log('hello du service');
  }

  getDataFromDataBase(): any {
    return null;
  }
}
