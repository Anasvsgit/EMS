package Employee.Management.System.Controller;

import Employee.Management.System.Model.LeaveDTO;
import Employee.Management.System.Service.LeaveService;
import Employee.Management.System.Util.Converter;
import Employee.Management.System.entities.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LeaveController {
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private Converter converter;
    @PostMapping("/createLeave")
    ResponseEntity<LeaveDTO> registerLeave(@Valid @RequestBody LeaveDTO leaveDTO)
    {
        final Leave leave=converter.convertToLeaveEntity(leaveDTO);
        return new ResponseEntity<LeaveDTO>(leaveService.createLeave(leave), HttpStatus.CREATED);
    }

    @PostMapping("/assignment1/{lve_id}/{eid}")
    public String assignEmployeetoLeave(@PathVariable("lve_id") int lve_id,
                                        @PathVariable("eid") int eid)
    {
        return leaveService.assignEmployeeToLeave(lve_id, eid);
    }
}
