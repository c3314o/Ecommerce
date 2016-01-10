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
 * Confirmation type.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "confirmations")
@Entity
@Table(name = "CONFIRMATION_TYPE")
public class ConfirmationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "confirmationType")
    private List<Confirmation> confirmations;

    @Column(name = "NAME", length = 50, nullable = false, unique = true)
    private String name;
}
