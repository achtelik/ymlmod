import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YmlOutputComponent } from './yml-output.component';

describe('YmlOutputComponent', () => {
  let component: YmlOutputComponent;
  let fixture: ComponentFixture<YmlOutputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YmlOutputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YmlOutputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
