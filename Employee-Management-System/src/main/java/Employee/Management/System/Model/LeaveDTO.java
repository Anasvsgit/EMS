package Employee.Management.System.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class LeaveDTO {
    private int lve_id;
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

}
