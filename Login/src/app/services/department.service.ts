import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../modals/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private baseUrl = 'http://localhost:35729/department';

  constructor(private http: HttpClient) { }

  loadDepartments(): Observable<Department[]> {
    return this.http.get<Department[]>(this.baseUrl);
  }
}