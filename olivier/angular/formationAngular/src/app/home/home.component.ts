import { FakeDemoService } from './../services/fake-demo.service';
import { DemoService } from './../services/demo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  // providers: [{ useClass: DemoService, provide: DemoService }],
})
export class HomeComponent implements OnInit {
  constructor(private demoService: DemoService) {}

  ngOnInit(): void {
    this.demoService.sayHello();
  }
}
