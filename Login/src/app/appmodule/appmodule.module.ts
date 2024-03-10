import { NgModule, importProvidersFrom } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from '../app.component';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { BrowserModule } from '@angular/platform-browser';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { AppRoutingModule } from '../app.routes';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { LoginService } from '../services/login.service';
import { ViewComponent } from '../dashboard/view/view.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    ViewComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    CardModule,
    InputTextModule,
    ReactiveFormsModule,
    ButtonModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers:[HttpClientModule]
})
export class AppmoduleModule { }
