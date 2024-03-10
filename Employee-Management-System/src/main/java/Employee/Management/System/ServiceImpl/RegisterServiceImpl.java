package Employee.Management.System.ServiceImpl;

import Employee.Management.System.Repository.RegisterRepository;
import Employee.Management.System.Service.RegisterService;
import Employee.Management.System.entities.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private RegisterRepository registerRepository;

    public RegisterServiceImpl() {
        super();
    }

    @Override
    public Register createregister(Register register) {
        return registerRepository.save(register);
    }
}
