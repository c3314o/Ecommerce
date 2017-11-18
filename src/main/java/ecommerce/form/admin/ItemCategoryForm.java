package ecommerce.form.admin;

import ecommerce.domain.ItemCategory;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Item category form.
 *
 * @author Jakub Polák
 */
@Data
public class ItemCategoryForm extends BaseForm<ItemCategory, ItemCategoryForm> {
    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    private Boolean isActive = Boolean.FALSE;

    private Integer position = 0;

    public ItemCategoryForm() {
        super(ItemCategoryForm.class, ItemCategory.class);
    }
}
