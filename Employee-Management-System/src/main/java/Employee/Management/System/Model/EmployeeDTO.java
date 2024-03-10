package Employee.Management.System.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO
{
    private int id;
    private String gender;
    private int age;
    private String contact;
    private String name;
    private String mail;
    //private String password;


    private DepartmentDTO department;
    private SalaryDTO salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public SalaryDTO getSalary() {
        return salary;
    }

    public void setSalary(SalaryDTO salary) {
        this.salary = salary;
    }

    public EmployeeDTO(int id, String gender, int age, String contact, String name, String mail, DepartmentDTO department, SalaryDTO salary) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
        this.name = name;
        this.mail = mail;
        this.department = department;
        this.salary = salary;
    }
}



