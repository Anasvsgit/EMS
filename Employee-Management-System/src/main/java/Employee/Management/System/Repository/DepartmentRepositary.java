package Employee.Management.System.Repository;

import Employee.Management.System.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositary extends JpaRepository<Department, Integer> {

}
