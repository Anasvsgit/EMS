package Employee.Management.System.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "leave1")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lve_id;

    @Column(name = "dt")
    private Date date;

    public int getLve_id() {
        return lve_id;
    }

    public void setLve_id(int lve_id) {
        this.lve_id = lve_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
