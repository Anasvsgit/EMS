import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Leave } from '../modals/leave';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  
  private baseUrl = 'http://localhost:8083/leave';
  getAllLeaves(): Observable<Leave[]> {
    return this.http.get<Leave[]>(this.baseUrl); 
  }

  constructor(private http: HttpClient) { }

  createLeave(leave: Leave): Observable<Leave> {
    return this.http.post<Leave>(`${this.baseUrl}/create`, leave);
  }

  assignLeaveToEmployee(leaveId: number, employeeId: number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/${leaveId}/assignToEmployee/${employeeId}`, null);
  }
}
