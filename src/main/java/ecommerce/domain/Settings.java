package ecommerce.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jakub Polák
 */
@Data
@Entity
@Table(name = "SETTINGS")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "ALLOW_STOCK", nullable = false)
    private Boolean allowStock = Boolean.TRUE;

    @Column(name = "ALLOW_TRANSLATION", nullable = false)
    private Boolean allowTranslation = Boolean.TRUE;

    @Column(name = "ALLOW_INVOICE", nullable = false)
    private Boolean allowInvoice = Boolean.TRUE;
}
