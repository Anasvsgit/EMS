import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Salary } from '../modals/salary';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  private baseUrl = 'http://localhost:8083/salary';
  getAllSalaries(): Observable<Salary[]> {
    return this.http.get<Salary[]>(this.baseUrl);
  }

  constructor(private http: HttpClient) { }

  createSalary(salary: Salary): Observable<Salary> {
    return this.http.post<Salary>(`${this.baseUrl}/create`, salary);
  }

  assignEmployeeToSalary(salaryId: number, employeeId: number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/${salaryId}/assignEmployee/${employeeId}`, null);
  }
}
