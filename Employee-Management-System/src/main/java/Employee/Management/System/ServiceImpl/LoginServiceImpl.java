package Employee.Management.System.ServiceImpl;

import Employee.Management.System.Repository.LoginRepository;
import Employee.Management.System.Service.LoginService;
import Employee.Management.System.entities.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public LoginServiceImpl() {
        super();
    }

    @Override
    public Login createlogin(Login login) {
        return loginRepository.save(login);
    }
}
