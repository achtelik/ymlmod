import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-yml-input',
  templateUrl: './yml-input.component.html',
  styleUrls: ['./yml-input.component.css']
})
export class YmlInputComponent {

  @Output()
  valueChange = new EventEmitter();

  constructor() {
  }


  handleInput(event: KeyboardEvent, textAreaElement: HTMLTextAreaElement) {
    if (event.key == 'Tab') {
      event.preventDefault();
      const s = textAreaElement.selectionStart;
      textAreaElement.value = textAreaElement.value.substring(0, textAreaElement.selectionStart) + "  " + textAreaElement.value.substring(textAreaElement.selectionEnd);
      textAreaElement.selectionEnd = s + 1;
    }

  }

  handleInputChanged($event: KeyboardEvent, textAreaElement: HTMLTextAreaElement) {
    this.valueChange.emit(textAreaElement.value);
  }
}
