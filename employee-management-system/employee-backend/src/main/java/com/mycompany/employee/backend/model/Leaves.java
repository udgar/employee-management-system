
package com.mycompany.employee.backend.model;

import com.mycompany.employee.backend.enumerations.LeaveType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Leaves {
    
    private Date fromDate;
    
    private Date toDate;
    
    private String reason;
    
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    
    private String duration;
    
    private boolean isOnleave;
    
}
