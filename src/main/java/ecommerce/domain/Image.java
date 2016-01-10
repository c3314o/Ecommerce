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

/**
 * Image.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "item")
@Entity
@Table(name = "IMAGE")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Column(name = "NAME", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "ALT", length = 100)
    private String alt;

    @Column(name = "POSITION", nullable = false)
    private Integer position = 0;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = Boolean.TRUE;
}
