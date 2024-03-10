package Employee.Management.System.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String Name;
    private String gender;
    private int age;
    private String contact;
    @Column(length = 50)
    private String mail;
    //@Column(unique = true)
    //private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

   // public String getPassword() {
     //   return password;
    //}

    //public void setPassword(String password) {
      //  this.password = password;
    //}

    public Employee() {
        super();
    }

    public Employee(int id, String name, String gender, int age, String contact, String mail, String password) {
        this.id = id;
        Name = name;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
        this.mail = mail;
        //this.password = password;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dep_id")
    @JsonIgnoreProperties("employee")
    private Department department;

    public Employee(int id, String name, String gender, int age, String contact, String mail, String password, Department department) {
        this.id = id;
        Name = name;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
        this.mail = mail;
        //this.password = password;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "s_id")
    @JsonIgnoreProperties("salaries")
    private Salary salary;

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String gender, int age, String contact, String mail, String password, Department department, Salary salary) {
        this.id = id;
        Name = name;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
        this.mail = mail;
        //this.password = password;
        this.department = department;
        this.salary = salary;
    }
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("leaves")
    private List<Leave> leaves;

    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }

    public Employee(int id, String name, String gender, int age, String contact, String mail, String password, Department department, Salary salary, List<Leave> leave) {
        this.id = id;
        Name = name;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
        this.mail = mail;
        //this.password = password;
        this.department = department;
        this.salary = salary;
        this.leaves = leave;
    }
}
