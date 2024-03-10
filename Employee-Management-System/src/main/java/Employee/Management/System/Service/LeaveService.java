package Employee.Management.System.Service;

import Employee.Management.System.Model.LeaveDTO;
import Employee.Management.System.entities.Employee;
import Employee.Management.System.entities.Leave;

public interface LeaveService {
    LeaveDTO createLeave(Leave leave);

    String assignEmployeeToLeave(int lve_id, int eid);
}
