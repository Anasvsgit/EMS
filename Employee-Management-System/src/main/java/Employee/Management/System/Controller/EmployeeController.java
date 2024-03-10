package Employee.Management.System.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import Employee.Management.System.entities.Employee;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.Service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    Converter converter;
    @PostMapping("api/createEmployee")
    ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)
    {
        final Employee employee=converter.convertToEmployeeEntity(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/api/getAllEmployees")
    List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/EmployeeById/{eid}")
    EmployeeDTO getEmployeeById(@PathVariable("eid") int id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/updateEmployee/{id}")
    EmployeeDTO updateEmployee(@Valid @PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        final Employee employee = converter.convertToEmployeeEntity(employeeDTO);
        return  employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    String deleteEmployee(@PathVariable int id)
    {
        return  employeeService.deleteEmployee(id);
    }

}
