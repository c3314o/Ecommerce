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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Item category.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"itemCategory", "itemCategories", "seo"})
@Entity
@Table(name = "ITEM_CATEGORY")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_CATEGORY_ID", referencedColumnName = "ID")
    private ItemCategory itemCategory;

    @OneToMany(mappedBy = "itemCategory")
    private List<ItemCategory> itemCategories;

    @OneToOne
    @JoinColumn(name = "SEO_ID", referencedColumnName = "ID")
    private Seo seo;

    @OneToMany(mappedBy = "itemCategory")
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "itemCategory")
    private List<Slug> slugs = new ArrayList<>();

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = Boolean.FALSE;

    @Column(name = "POSITION", nullable = false)
    private Integer position = 0;
}
