package Employee.Management.System.Controller;

import Employee.Management.System.Model.DepartmentDTO;
import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.Service.DepartmentService;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private Converter converter;
    @PostMapping("/createDepartment")
    ResponseEntity<DepartmentDTO> registerDepartment(@Valid @RequestBody DepartmentDTO departmentDTO)
    {
        final Department department=converter.convertToDeparmentEntity(departmentDTO);
        return new ResponseEntity<DepartmentDTO>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @PostMapping("/assignment/{dept_id}/{eid}")
    public String assignEmployeeToDepartment(@PathVariable("dept_id") int dept_id,
                                         @PathVariable("eid") int eid)
    {
        return departmentService.assignEmployeeToDepartment(dept_id, eid);
    }
    @GetMapping("/DepartmentByID/{dept_id}")
    DepartmentDTO getDepartmentByID(@PathVariable("dept_id") int id){
        return departmentService.getDepartmentByID(id);
    }

}
