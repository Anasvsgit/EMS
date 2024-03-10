package Employee.Management.System.ServiceImpl;

import Employee.Management.System.Exception.ResourceNotFoundException;
import Employee.Management.System.Model.LeaveDTO;
import Employee.Management.System.Repository.EmployeeRepository;
import Employee.Management.System.Repository.LeaveRepository;
import Employee.Management.System.Service.LeaveService;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.entities.Employee;
import Employee.Management.System.entities.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService{
    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Converter converter;

    @Override
    public LeaveDTO createLeave(Leave leave) {
        Leave lve = leaveRepository.save(leave);
        return converter.convertToLeaveDTO(lve);
    }
    @Override
    public String assignEmployeeToLeave(int lve_id, int eid) {

        Employee e = employeeRepository.findById(eid).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", eid));

        Leave l = leaveRepository.findById(lve_id).orElseThrow(() ->
                new ResourceNotFoundException("Leave", "Id", lve_id));



        //assign Employee to Leave
        l.setEmployee(e);

        //assign Leave to Employeee
        e.setLeaves(Arrays.asList(l));

        leaveRepository.save(l);
        return "Leave assigned to Employee  successfully";
    }
}

