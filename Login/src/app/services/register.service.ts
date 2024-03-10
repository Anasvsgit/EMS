import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from '../modals/register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private baseUrl = 'http://localhost:8083/api/createregister';

  constructor(private http: HttpClient) { }

  createRegister(registerData: Register): Observable<Register> {
    return this.http.post<Register>(this.baseUrl, registerData);
  }
}
