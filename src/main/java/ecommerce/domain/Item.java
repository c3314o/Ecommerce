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
import java.math.BigDecimal;
import java.util.List;

/**
 * Item.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"vat", "seo", "itemCategory", "slugs", "attributes", "amountOnStocks", "images"})
@Entity
@Table(name = "ITEM")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "VAT_ID", referencedColumnName = "ID", nullable = false)
    private Vat vat;

    @ManyToOne
    @JoinColumn(name = "ITEM_CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    private ItemCategory itemCategory;

    @OneToMany(mappedBy = "item")
    private List<ItemHasAttribute> attributes;

    @OneToMany(mappedBy = "item")
    private List<AmountOnStock> amountOnStocks;

    @OneToMany(mappedBy = "item")
    private List<Image> images;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "POSITION", nullable = false)
    private Integer position = 0;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = Boolean.FALSE;

    @Column(name = "IS_DISCOUNT", nullable = false)
    private Boolean isDiscount = Boolean.FALSE;

    @Column(name = "GROUP_CODE")
    private String groupCode;

    @Column(name = "PRICE_DISCOUNT_INC_VAT", precision = 10, scale = 2, nullable = false)
    private BigDecimal priceDiscountIncVat = new BigDecimal(0);

    @Column(name = "PRICE_DISCOUNT_EXL_VAT", precision = 10, scale = 2, nullable = false)
    private BigDecimal priceDiscountExlVat = new BigDecimal(0);

    @Column(name = "PRICE_INC_VAT", precision = 10, scale = 2, nullable = false)
    private BigDecimal priceIncVat = new BigDecimal(0);

    @Column(name = "PRICE_EXL_VAT", precision = 10, scale = 2, nullable = false)
    private BigDecimal priceExlVat = new BigDecimal(0);

    @Column(name = "DISCOUNT_PERCENT", nullable = false)
    private Integer discountPercent = 0;
}
