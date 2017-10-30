package ecommerce.form.admin;

import ecommerce.domain.ItemCategory;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Item category form.
 *
 * @author Jakub Polák
 */
public class ItemCategoryForm extends BaseForm<ItemCategory, ItemCategoryForm> {
    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    private Boolean isActive = Boolean.FALSE;

    private Integer position = 0;

    public ItemCategoryForm(Class<ItemCategoryForm> classForm, Class<ItemCategory> classEntity) {
        super(classForm, classEntity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
