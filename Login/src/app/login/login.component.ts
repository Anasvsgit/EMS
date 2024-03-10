import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { LoginService } from '../services/login.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Login } from '../modals/login';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,CardModule,ReactiveFormsModule,InputTextModule,ButtonModule,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm = this.fb.group({
    email:['',[Validators.required, Validators.email]],
    password: ['',Validators.required]
  })

  constructor(private fb: FormBuilder,private loginService: LoginService)
  {

   }

  get  email(){
    return this.loginForm.controls['email'];
  }
  get password(){
    return this.loginForm.controls['password'];
  }
  areMandatoryFieldsEmpty(): boolean {
    const emailControl =  this.loginForm.controls['email'];
    const passwordControl = this.loginForm.controls['password'];
    return !emailControl.value || !passwordControl.value 
  }
  onSubmit() {
    const emailValue = this.loginForm.controls['email']?.value;
    const passwordValue = this.loginForm.controls['password']?.value;
    
    if (emailValue != null && passwordValue != null) {
      // Pass email and password directly to the service method
      const loginData = { email: emailValue, password: passwordValue }; // Create an object with email and password properties
      this.loginService.createlogin(loginData).subscribe(
        response => {
          // Handle the response from the service if needed
          console.log(response);
          alert("LOGIN SUCCESS");
        },
        error => {
          // Handle any errors from the service
          console.error(error);
          alert("ERROR INSIDE");
        }
      );
    }
  }
}