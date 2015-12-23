package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"customerOrder", "state"})
@Entity
@Table(name = "STATE_CHANGE")
public class StateChange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ORDER_ID", referencedColumnName = "ID")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "STATE_ID", referencedColumnName = "ID")
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHANGED_ON")
    private Date changeOn;
}
