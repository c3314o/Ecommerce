package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Item has attribute.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"attribute", "item"})
@Entity
@Table(name = "ITEM_HAS_ATTRIBUTE")
public class ItemHasAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Attribute attribute;

    @ManyToOne
    private Item item;
    
    @Column(name = "VALUE", nullable = false)
    private String value;
}
