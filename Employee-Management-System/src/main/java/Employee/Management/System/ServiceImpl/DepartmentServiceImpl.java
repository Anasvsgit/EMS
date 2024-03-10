package Employee.Management.System.ServiceImpl;

import Employee.Management.System.Exception.ResourceNotFoundException;
import Employee.Management.System.Model.DepartmentDTO;
import Employee.Management.System.Repository.DepartmentRepositary;
import Employee.Management.System.Repository.EmployeeRepository;
import Employee.Management.System.Service.DepartmentService;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.entities.Department;
import Employee.Management.System.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepositary departmentRepositary;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Converter converter;
    @Override
    public DepartmentDTO createDepartment(Department department) {
        Department dept=departmentRepositary.save(department);
        return converter.convertToDepartmentDTO(dept);
    }

    @Override
    public String assignEmployeeToDepartment(int dep_id, int eid) {
        Employee e=employeeRepository.findById(eid).orElseThrow(()->
                new ResourceNotFoundException("Employee", "Id", eid));

        Department  d=departmentRepositary.findById(dep_id).orElseThrow(()->
                new ResourceNotFoundException("Teacher", "Id", dep_id));

        List<Employee> employees=new ArrayList<>();
        employees.add(e);

        //assign Employee to Department
        d.setEmployees(employees);

        //assign Department to Employeee
        e.setDepartment(d);

        departmentRepositary.save(d);
        return "Employee assigned to department  successfully";
    }

    @Override
    public DepartmentDTO getDepartmentByID(int dept_id) {
        Department d = departmentRepositary.findById(dept_id).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", dept_id));
        return converter.convertToDepartmentDTO(d);
    }
}
