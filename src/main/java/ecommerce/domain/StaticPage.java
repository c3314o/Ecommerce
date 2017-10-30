package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Static page.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "slugs")
@Entity
@Table(name = "STATIC_PAGE")
public class StaticPage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "HEADING", nullable = false)
    private String heading;

    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = Boolean.FALSE;
}
