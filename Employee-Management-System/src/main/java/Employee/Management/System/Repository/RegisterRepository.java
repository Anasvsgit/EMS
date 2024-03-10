package Employee.Management.System.Repository;

import Employee.Management.System.entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Integer> {
}
