package Employee.Management.System.Repository;

import Employee.Management.System.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepositary extends JpaRepository<Salary, Integer> {

}
