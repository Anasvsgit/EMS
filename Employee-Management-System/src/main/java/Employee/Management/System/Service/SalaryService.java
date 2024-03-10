package Employee.Management.System.Service;

import Employee.Management.System.Model.SalaryDTO;
import Employee.Management.System.Repository.SalaryRepositary;
import Employee.Management.System.entities.Salary;
import org.springframework.stereotype.Service;

public interface SalaryService {
    SalaryDTO createSalary(Salary salary);
    String assignEmployeeToSalary(int s_id, int eid);
}
