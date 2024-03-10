import { Component, Input, OnInit, input } from '@angular/core';
import { Salary } from '../../modals/salary';
import { SalaryService } from '../../services/salary.service';
import { Employee } from '../../modals/employee';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-salary',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './salary.component.html',
  styleUrl: './salary.component.css'
})
export class SalaryComponent implements OnInit {
  @Input() employees!: Employee[]; 
  salaries: Salary[]  =[];

    constructor(private salaryService: SalaryService) { }

    ngOnInit(): void {
        this.loadSalaries();
    }

    loadSalaries(): void {
        this.salaryService.getAllSalaries()
            .subscribe(
                (data: Salary[]) => this.salaries = data,
                (error: any) => console.error(error)
            );
    }

}
