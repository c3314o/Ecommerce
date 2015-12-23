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
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"language", "itemCategory", "item", "article", "menu", "staticPage"})
@Entity
@Table(name = "SLUG")
public class Slug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "ID")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "ITEM_CATEGORY_ID", referencedColumnName = "ID")
    private ItemCategory itemCategory;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "MENU_ID", referencedColumnName = "ID")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "STATIC_PAGE_ID", referencedColumnName = "ID")
    private StaticPage staticPage;

    @Column(name = "VALUE", nullable = false)
    private String value;
}
