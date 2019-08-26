import {Component, OnInit} from '@angular/core';
import {YmlService} from "../yml.service";

@Component({
  selector: 'app-yml-page',
  templateUrl: './yml-page.component.html',
  styleUrls: ['./yml-page.component.css']
})
export class YmlPageComponent implements OnInit {

  inputYml: string = '';
  outputYml: string = '';

  constructor(private ymlService: YmlService) {
  }

  ngOnInit() {
  }

  handleInputChange($event: string) {
    console.log("handleInputChange")
    this.inputYml = $event;
    this.ymlService.postYml({yml: btoa($event)}).subscribe(data => this.outputYml = data.yml
    );
  }
}
