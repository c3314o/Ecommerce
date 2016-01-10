package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Seo.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"item", "itemCategory"})
@Entity
@Table(name = "SEO")
public class Seo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(mappedBy = "seo")
    private Item item;

    @OneToOne(mappedBy = "seo")
    private ItemCategory itemCategory;
}
