package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "stateChanges")
@Entity
@Table(name = "STATE")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "state")
    private List<StateChange> stateChanges;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "EMAIL_TEMPLATE")
    private String emailTemplate;

    @Column(name = "SEND_EMAIL", nullable = false)
    private Boolean sendEmail = Boolean.FALSE;
}
