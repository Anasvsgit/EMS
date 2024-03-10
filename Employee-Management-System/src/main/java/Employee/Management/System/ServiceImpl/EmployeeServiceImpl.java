package Employee.Management.System.ServiceImpl;

import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.Repository.EmployeeRepository;
import Employee.Management.System.Service.EmployeeService;
import Employee.Management.System.entities.Employee;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Converter converter;

    @Override
    public EmployeeDTO createEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return converter.convertToEmployeeDTO(emp);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (Employee e : employees) {
            dtoList.add(converter.convertToEmployeeDTO(e));
        }
        return dtoList;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employee e = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        return converter.convertToEmployeeDTO(e);
    }

    @Override
    public EmployeeDTO updateEmployee(int id, Employee employee) {
        Employee e = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

        e.setName(employee.getName());
        e.setAge(employee.getAge());
        e.setGender(employee.getGender());
        e.setMail(employee.getMail());
        e.setContact(employee.getContact());
        //e.setPassword(employee.getPassword());

        Employee emp = employeeRepository.save(e);
        return converter.convertToEmployeeDTO(emp);
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee with ID " + id + " deleted successfully!";
    }
}