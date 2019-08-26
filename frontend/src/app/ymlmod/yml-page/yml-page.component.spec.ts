import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YmlPageComponent } from './yml-page.component';

describe('YmlPageComponent', () => {
  let component: YmlPageComponent;
  let fixture: ComponentFixture<YmlPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YmlPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YmlPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
