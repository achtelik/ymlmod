import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {YmlInputComponent} from './yml-input/yml-input.component';
import {YmlPageComponent} from './yml-page/yml-page.component';
import {SharedModule} from "../shared/shared.module";
import { YmlOutputComponent } from './yml-output/yml-output.component';


@NgModule({
  declarations: [YmlInputComponent, YmlPageComponent, YmlOutputComponent],
  exports: [
    YmlPageComponent
  ],
  imports: [
    SharedModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class YmlmodModule {
}
