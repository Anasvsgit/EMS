package Employee.Management.System.Service;

import Employee.Management.System.Model.DepartmentDTO;
import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.entities.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(Department department);
    String assignEmployeeToDepartment(int dep_id, int eid);
    DepartmentDTO getDepartmentByID(int id);

}
