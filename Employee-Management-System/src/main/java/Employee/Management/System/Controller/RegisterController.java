package Employee.Management.System.Controller;

import Employee.Management.System.Service.RegisterService;
import Employee.Management.System.entities.Login;
import Employee.Management.System.entities.Register;
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
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/api/createregister")
    ResponseEntity<Register> createLogin(@Valid @RequestBody Register register)
    {
        return new ResponseEntity<Register>(registerService.createregister(register), HttpStatus.CREATED);
    }

}
