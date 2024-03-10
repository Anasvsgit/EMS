import { Component, OnInit } from '@angular/core';
import { Employee } from '../../modals/employee';
import { EmployeeService } from '../../services/employee.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAllEmployee()
      .subscribe(
        (data: Employee[]) => {
          this.employees = data;
          alert('s');
        },
        (error: any) => {
          console.error(error);
          alert('f');
        }
      );
  }
}
