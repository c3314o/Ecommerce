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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Vat.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "items")
@Entity
@Table(name = "VAT")
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "vat")
    private List<Item> items = new ArrayList<>();

    @Column(name = "VALUE", nullable = false)
    private BigDecimal value = new BigDecimal(0);

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_DEFAULT", nullable = false)
    private Boolean isDefault = Boolean.FALSE;
}
