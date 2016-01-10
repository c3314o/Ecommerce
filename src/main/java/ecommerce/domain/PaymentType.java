package ecommerce.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Payment type.
 *
 * @author Jakub Polák
 */
@Data
@Entity
@Table(name = "PAYMENT_TYPE")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "PRICE_INC_VAT", nullable = false, scale = 10, precision = 2)
    private BigDecimal priceIncVat = new BigDecimal(0);

    @Column(name = "PRICE_EXL_VAT", nullable = false, scale = 10, precision = 2)
    private BigDecimal priceExlVat = new BigDecimal(0);

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = Boolean.FALSE;
}
