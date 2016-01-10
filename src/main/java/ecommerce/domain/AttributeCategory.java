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
 * Attribute category.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "attributes")
@Entity
@Table(name = "ATTRIBUTE_CATEGORY")
public class AttributeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "attributeCategory")
    private List<Attribute> attributes;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
}
