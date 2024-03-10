package Employee.Management.System.Repository;

import Employee.Management.System.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave,Integer> {
}
