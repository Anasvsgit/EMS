import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../modals/login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = 'http://localhost:8083/api/createlogin';

  constructor(private http: HttpClient) { }

  createlogin(auth: Login): Observable<Login> {
    return this.http.post<Login>(this.baseUrl, auth);
  }

}
