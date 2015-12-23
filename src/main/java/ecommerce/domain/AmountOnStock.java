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
@ToString(exclude = {"stock", "item"})
@Entity
@Table(name = "AMOUNT_ON_STOCK")
public class AmountOnStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STOCK_ID", referencedColumnName = "ID", nullable = false)
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", nullable = false)
    private Item item;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;
}
