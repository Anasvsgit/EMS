import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { NgModule } from '@angular/core';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeService } from './services/employee.service';
import { RegisterService } from './services/register.service';
import { ViewComponent } from './dashboard/view/view.component';

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path:'register',
        component: RegisterComponent
    },
    {
        path:'dashboard',
        component:DashboardComponent
    },
    {
        path:'employee',
        component: EmployeeComponent
    },
    {
        path: 'view',
        component: ViewComponent
    },
    {
        path: '', redirectTo: '/login', pathMatch: 'full' 
    }

];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }