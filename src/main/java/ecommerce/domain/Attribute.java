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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"itemHasAttributes", "attributeCategory"})
@Entity
@Table(name = "ATTRIBUTE")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "attribute")
    private List<ItemHasAttribute> itemHasAttributes;

    @ManyToOne
    @JoinColumn(name = "ATTRIBUTE_CATEGORY_ID", referencedColumnName = "ID")
    private AttributeCategory attributeCategory;

    @Column(name = "NAME", length = 50, nullable = false, unique = true)
    private String name;
}
