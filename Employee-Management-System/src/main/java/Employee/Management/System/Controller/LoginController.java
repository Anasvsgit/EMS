package Employee.Management.System.Controller;

import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.Service.LoginService;
import Employee.Management.System.entities.Employee;
import Employee.Management.System.entities.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/api/createlogin")
    ResponseEntity<Login> createLogin(@Valid @RequestBody Login login)
    {
        return new ResponseEntity<Login>(loginService.createlogin(login), HttpStatus.CREATED);
    }
}
