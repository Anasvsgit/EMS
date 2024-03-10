package Employee.Management.System.ServiceImpl;

import Employee.Management.System.Exception.ResourceNotFoundException;
import Employee.Management.System.Model.SalaryDTO;
import Employee.Management.System.Repository.EmployeeRepository;
import Employee.Management.System.Repository.SalaryRepositary;
import Employee.Management.System.Service.SalaryService;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.entities.Department;
import Employee.Management.System.entities.Employee;
import Employee.Management.System.entities.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepositary salaryRepositary;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Converter converter;
    @Override
    public SalaryDTO createSalary(Salary salary) {
        Salary sal=salaryRepositary.save(salary);
        return converter.convertToSalaryDTO(sal);
    }

    @Override
    public String assignEmployeeToSalary(int s_id, int eid) {
        Employee e=employeeRepository.findById(eid).orElseThrow(()->
                new ResourceNotFoundException("Employee", "Id", eid));

        Salary  s=salaryRepositary.findById(s_id).orElseThrow(()->
                new ResourceNotFoundException("Salary", "Id", s_id));

        List<Employee> employees=new ArrayList<>();
        employees.add(e);

        //assign Employee to Salary
        s.setEmployees(employees);

        //assign Salary to Employeee
        e.setSalary(s);

        salaryRepositary.save(s);
        return "Salary assigned to Employee  successfully";
    }

}
