package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Invoice.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "customerOrder")
@Entity
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ORDER_ID", referencedColumnName = "ID", nullable = false)
    private CustomerOrder customerOrder;

    @Column(name = "NUMBER", nullable = false, unique = true)
    private String number;

    @Column(name = "CONTENT", nullable = false)
    private String content;
}
