import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YmlInputComponent } from './yml-input.component';

describe('YmlInputComponent', () => {
  let component: YmlInputComponent;
  let fixture: ComponentFixture<YmlInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YmlInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YmlInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
