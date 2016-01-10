package ecommerce.form.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Item category form.
 *
 * @author Jakub Polák
 */
@Data
public class ItemCategoryForm {
    private Long id;

    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    private Boolean isActive = Boolean.FALSE;

    private Integer position = 0;
}
