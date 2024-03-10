import { Component, Input, OnInit } from '@angular/core';
import { Leave } from '../../modals/leave';
import { LeaveService } from '../../services/leave.service';
import { Employee } from '../../modals/employee';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-leave',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './leave.component.html',
  styleUrl: './leave.component.css'
})
export class LeaveComponent implements OnInit{
  @Input() employees!: Employee[];
  leaves: Leave[] = [];

  constructor(private leaveService: LeaveService) { }

  ngOnInit(): void {
    this.loadLeaves();
  }

  loadLeaves(): void {
    this.leaveService.getAllLeaves()
      .subscribe(
        (data: Leave[]) => this.leaves = data,
        (error: any) => console.error(error) 
      );
  }

}
