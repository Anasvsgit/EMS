package Employee.Management.System.Util;

import Employee.Management.System.Model.DepartmentDTO;
import Employee.Management.System.Model.LeaveDTO;
import Employee.Management.System.Model.SalaryDTO;
import Employee.Management.System.entities.Department;
import Employee.Management.System.entities.Leave;
import Employee.Management.System.entities.Salary;
import org.springframework.stereotype.Component;
import Employee.Management.System.Model.EmployeeDTO;
import Employee.Management.System.entities.Employee;
import org.springframework.beans.BeanUtils;
@Component
public class Converter {
    public Employee convertToEmployeeEntity(EmployeeDTO employeeDTO)
    {
        Employee employee=new Employee();
        if(employeeDTO!=null)
        {
            BeanUtils.copyProperties(employeeDTO, employee);
        }
        return employee;
    }

    //convert from entity to DTO

    public EmployeeDTO convertToEmployeeDTO(Employee employee)
    {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        if(employee!=null)
        {
            BeanUtils.copyProperties(employee, employeeDTO);
            DepartmentDTO departmentDTO = new DepartmentDTO();
            BeanUtils.copyProperties(employee.getDepartment(), departmentDTO);
            employeeDTO.setDepartment(departmentDTO);
            SalaryDTO salaryDTO = new SalaryDTO();
            BeanUtils.copyProperties(employee.getSalary(), salaryDTO);
            employeeDTO.setSalary(salaryDTO);
        }
        return employeeDTO;
    }
    public Department convertToDeparmentEntity(DepartmentDTO departmentDTO)
    {
        Department department=new Department();
        if(departmentDTO!=null)
        {
            BeanUtils.copyProperties(departmentDTO, department);
        }
        return department;
    }

    //convert from Entity to DTO
    public DepartmentDTO convertToDepartmentDTO(Department department)
    {
        DepartmentDTO departmentDTO=new DepartmentDTO();
        if(department!=null)
        {
            BeanUtils.copyProperties(department, departmentDTO);
        }
        return departmentDTO;
    }
    public Salary convertToSalaryEntity(SalaryDTO salaryDTO){
        Salary salary = new Salary();
        if(salaryDTO!=null)
        {
            BeanUtils.copyProperties(salaryDTO, salary);
        }
        return salary;
    }
    public SalaryDTO convertToSalaryDTO(Salary salary){
        SalaryDTO salaryDTO=new SalaryDTO();
        if(salary!=null)
        {
            BeanUtils.copyProperties(salary, salaryDTO);
        }
        return salaryDTO;
    }
    public Leave convertToLeaveEntity(LeaveDTO leaveDTO){
        Leave leave = new Leave();
        if(leaveDTO!=null)
        {
            BeanUtils.copyProperties(leaveDTO, leave);
        }
        return leave;
    }
    public LeaveDTO convertToLeaveDTO(Leave leave){
        LeaveDTO leaveDTO=new LeaveDTO();
        if(leave!=null)
        {
            BeanUtils.copyProperties(leave, leaveDTO);
        }
        return leaveDTO;
    }
}

