import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { RegisterService } from '../services/register.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule,CardModule,InputTextModule,ButtonModule,HttpClientModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerForm = this.fb.group({
    fullName: ['',[Validators.required, Validators.pattern(/^[a-zA-Z]+(?: [a-zA-Z]+)*$/)]],
    email :['',[Validators.required, Validators.email]],
    password: ['',Validators.required],
    confirmPassword: ['',Validators.required]
  })

  constructor(private fb: FormBuilder,private registerservice: RegisterService) { }

get fullName(){
  return this.registerForm.controls['fullName'];
}
get email(){
  return this.registerForm.controls['email'];
}
get password(){
  return this.registerForm.controls['password'];
}
get confirmPassword(){
  return this.registerForm.controls['confirmPassword'];
}
// Function to check if any mandatory fields are empty
areMandatoryFieldsEmpty(): boolean {
  const nameControl =  this.registerForm.controls['fullName'];
  const genderControl = this.registerForm.controls['email'];
  const ageControl = this.registerForm.controls['password'];
  const emailControl =this.registerForm.controls['confirmPassword'];
  return !nameControl.value || !genderControl.value || !ageControl.value  || !emailControl.value;
}
onSubmit(){
  const fullNameValue = this.registerForm.controls['fullName']?.value;
  const emailValue = this.registerForm.controls['email']?.value;
  const passwordValue = this.registerForm.controls['password']?.value;
  const confirmPasswordValue = this.registerForm.controls['confirmPassword']?.value;

  
  if (fullNameValue != null && emailValue != null && passwordValue != null && confirmPasswordValue != null)
  {
    // Pass email and password directly to the service method
    const registerData = 
    { 
      fullName: fullNameValue, 
      email: emailValue, 
      password: passwordValue, 
      confirmPassword: confirmPasswordValue 
    }; // Create an object with email and password properties

    this.registerservice.createRegister(registerData).subscribe(
      response => {
        // Handle the response from the service if needed
        console.log(response);
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