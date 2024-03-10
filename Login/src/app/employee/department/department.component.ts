import { Component, Input, OnInit } from '@angular/core';
import { Department } from '../../modals/department';
import { DepartmentService } from '../../services/department.service';
import { CommonModule } from '@angular/common';
import { Employee } from '../../modals/employee';

@Component({
  selector: 'app-department',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './department.component.html',
  styleUrl: './department.component.css'
})
export class DepartmentComponent implements OnInit{
  @Input() employees!: Employee[];
  departments: Department[] =[];

  constructor(private departmentService: DepartmentService) { }

  loadDepartments(): void {
    this.departmentService.loadDepartments()
        .subscribe((data: Department[]) => {
            this.departments = data;
        });

  }
  ngOnInit(): void {
    this.loadDepartments();
  }
  

}
