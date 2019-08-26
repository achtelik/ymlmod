import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {YmlmodModule} from "./ymlmod/ymlmod.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule, Routes} from "@angular/router";
import {YmlPageComponent} from "./ymlmod/yml-page/yml-page.component";
import {HttpClientModule} from "@angular/common/http";

const appRoutes: Routes = [
  {path: '', component: YmlPageComponent},
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    NgbModule,
    YmlmodModule
  ],
  exports: [],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
