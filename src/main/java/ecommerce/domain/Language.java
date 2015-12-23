package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Jakub Polák
 */
@Data
@ToString(exclude = "slugs")
@Entity
@Table(name = "LANGUAGE")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "language")
    private List<Slug> slugs;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "IS_DEFAULT", nullable = false)
    private Boolean isDefault = Boolean.FALSE;
}
