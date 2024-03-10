package Employee.Management.System.Repository;

import Employee.Management.System.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {

}
