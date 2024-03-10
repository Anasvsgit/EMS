package Employee.Management.System.Service;

import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.entities.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(Employee employee);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeById(int id);
    EmployeeDTO updateEmployee(int id,Employee employee);
    String deleteEmployee(int id);

}
