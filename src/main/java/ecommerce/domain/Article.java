package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "slugs")
@Entity
@Table(name = "ARTICLE")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "article")
    private List<Slug> slugs;

    @Column(name = "HEADING", length = 255, nullable = false)
    private String heading;

    @Lob
    @Column(name = "TEXT", nullable = false)
    private String text;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive = Boolean.FALSE;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PUBLISHED_ON")
    private Date publishedOn = new Date();
}
