import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'angular-learning'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('angular-learning');
  });

//  it('should render title', () => {
//    const fixture = TestBed.createComponent(AppComponent);
//    fixture.detectChanges();
//    const compiled = fixture.nativeElement;
//    expect(compiled.querySelector('.content span').textContent).toContain('angular-learning app is running!');
//  });

 // it(`should have as favourite movie 'Lord of the Rings' `,() => {
 //   const fixture = TestBed.createComponent(AppComponent);
 //   fixture.detectChanges();
 //   const app = fixture.componentInstance;
 //   const compiled = fixture.debugElement.nativeElement;
 //   expect(compiled.querySelector('h3').textContent).toContain(app.favouriteMovie);
 // });

//  it(`should have as department name 'CSE' `,() => {
//    const fixture = TestBed.createComponent(AppComponent);
//    fixture.detectChanges();
//    const app = fixture.componentInstance;
//    const compiled = fixture.debugElement.nativeElement;
//    expect(compiled.querySelector("#departmentName").textContent).toContain(app.employee.department.name);
//  });
});
