import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FakeDemoService {
  constructor() {}

  sayHello() {
    console.log('le service fake demo le temps que Demo soit fonctionnel');
  }

  getDataFromDataBase(): any {
    return [{ nom: 'tele', prix: 123 }];
  }
}
