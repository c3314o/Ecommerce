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
@ToString(exclude = {"confirmationType", "user"})
@Entity
@Table(name = "CONFIRMATION")
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CONFIRMATION_TYPE_ID", referencedColumnName = "ID", nullable = false)
    private ConfirmationType confirmationType;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VALID_UNTIL")
    private Date validUntil;

    @Column(name = "VALUE", nullable = false, unique = true)
    private String value;
}
