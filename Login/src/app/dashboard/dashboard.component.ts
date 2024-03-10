import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from '../services/employee.service';


@Component({
  selector: 'app-dashboard',
  standalone:true,
  imports:[CommonModule,ReactiveFormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{
  empDetail!: FormGroup;
  empDepartment!: FormGroup;
  empLeave!: FormGroup;
  empSalary!: FormGroup;

  constructor(private formBuilder: FormBuilder, private employeeservice: EmployeeService) { }

  ngOnInit(): void {
    this.empDetail = this.formBuilder.group({
      name: [''],
      gender:[' '],
      age:[' '],
      contact:[' '],
      email: [''],
      password:[' ']
    });
    this.empDepartment = this.formBuilder.group({
      name: ['']
    });
    this.empLeave = this.formBuilder.group({
      Date:['']
    })
    this.empSalary = this.formBuilder.group({
      amount:[' '],
      Date:[' ']
    })
  }
  onEmployee(){
    const nameValue = this.empDetail.controls['Name']?.value;
    const genderValue = this.empDetail.controls['Gender']?.value;
    const ageValue = this.empDetail.controls['Age']?.value;
    const contactValue = this.empDetail.controls['Contact']?.value;
    const mailValue = this.empDetail.controls['email']?.value;
  

  if (nameValue != null && genderValue != null && ageValue != null && contactValue != null && mailValue != null) {
    // Pass email and password directly to the service method
    const employee = 
    { 
      name: nameValue, 
      gender: genderValue,
      age: ageValue,
      contact: contactValue,
      mail: mailValue,  
    }; // Create an object with email and password properties
    this.employeeservice.createEmployee(employee).subscribe(
      response => {
        // Handle the response from the service if needed
        console.log(response);
        alert("EMPLOYEE ADDED SUCCESSFULLY");
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

