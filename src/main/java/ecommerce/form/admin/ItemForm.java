package ecommerce.form.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Item form.
 *
 * @author Jakub Polák
 */
@Data
public class ItemForm {
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
}
