import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Employee } from '../modals/employee';
import { EmployeeService } from '../services/employee.service';
import { CommonModule } from '@angular/common';
import { LeaveComponent } from './leave/leave.component';
import { DepartmentComponent } from './department/department.component';
import { SalaryComponent } from './salary/salary.component';


@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule,LeaveComponent,DepartmentComponent,SalaryComponent],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAllEmployees();
  }

  getAllEmployees(): void {
    this.employeeService.getAllEmployee().subscribe(
      (data: Employee[]) => {
        this.employees = data;
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

}
  

