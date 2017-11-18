package ecommerce.form.admin;

import ecommerce.domain.Item;
import ecommerce.domain.ItemCategory;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Item form.
 *
 * @author Jakub Polák
 */
public class ItemForm extends BaseForm<Item, ItemForm> {
    private Long id;

    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    private String description;

    private Integer position;

    private Boolean isActive = Boolean.FALSE;

    private Boolean isDiscount = Boolean.FALSE;

    private String groupCode;

    private BigDecimal priceDiscountIncVat = new BigDecimal(0);

    private BigDecimal priceExlVat = new BigDecimal(0);

    private Integer discountPercent = 0;

    private Iterable<ItemCategory> itemCategories;

    private ItemCategory itemCategory;

    public ItemForm() {
        super(ItemForm.class, Item.class);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDiscount() {
        return isDiscount;
    }

    public void setDiscount(Boolean discount) {
        isDiscount = discount;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public BigDecimal getPriceDiscountIncVat() {
        return priceDiscountIncVat;
    }

    public void setPriceDiscountIncVat(BigDecimal priceDiscountIncVat) {
        this.priceDiscountIncVat = priceDiscountIncVat;
    }

    public BigDecimal getPriceExlVat() {
        return priceExlVat;
    }

    public void setPriceExlVat(BigDecimal priceExlVat) {
        this.priceExlVat = priceExlVat;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Iterable<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(Iterable<ItemCategory> itemCategories) {
        this.itemCategories = itemCategories;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
