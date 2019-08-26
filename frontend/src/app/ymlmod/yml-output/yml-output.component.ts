import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-yml-output',
  templateUrl: './yml-output.component.html',
  styleUrls: ['./yml-output.component.css']
})
export class YmlOutputComponent {

  @Input()
  value: string;

  constructor() {
  }

}
