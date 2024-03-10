import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { View } from '../modals/view';

@Injectable({
  providedIn: 'root'
})
export class ViewService {

  private baseUrl = 'http://localhost:8083/api'; // Update the URL to match your backend API

  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<View[]> {
    return this.http.get<View[]>(`${this.baseUrl}/getAllEmployees`);
  }

  // Add more methods to interact with your backend as needed
}