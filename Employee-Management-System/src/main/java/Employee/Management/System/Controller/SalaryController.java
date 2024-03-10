package Employee.Management.System.Controller;

import Employee.Management.System.Model.DepartmentDTO;
import Employee.Management.System.Model.SalaryDTO;
import Employee.Management.System.Repository.SalaryRepositary;
import Employee.Management.System.Service.SalaryService;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.entities.Department;
import Employee.Management.System.entities.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SalaryController {
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private Converter converter;
    @PostMapping("/createSalary")
    ResponseEntity<SalaryDTO> registerSalary(@Valid @RequestBody SalaryDTO salaryDTO)
    {
        final Salary salary=converter.convertToSalaryEntity(salaryDTO);
        return new ResponseEntity<SalaryDTO>(salaryService.createSalary(salary), HttpStatus.CREATED);
    }

    @PostMapping("/assignment2/{s_id}/{eid}")
    public String assignEmployeetoSalary(@PathVariable("s_id") int s_id,
                                         @PathVariable("eid") int eid)
    {
        return salaryService.assignEmployeeToSalary(s_id, eid);
    }
}
