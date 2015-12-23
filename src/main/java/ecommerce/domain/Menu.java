package ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"menu", "menus", "menuType", "slugs"})
@Entity
@Table(name = "MENU")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MENU_ID", referencedColumnName = "ID")
    private Menu menu;

    @OneToMany(mappedBy = "menu")
    private List<Menu> menus = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "MENU_TYPE_ID")
    private MenuType menuType;

    @OneToMany(mappedBy = "menu")
    private List<Slug> slugs = new ArrayList<>();

    @Column(name = "NAME", nullable = false)
    private String name;

    @Lob
    @Column(name = "CONTENT")
    private String content;

    @Column(name = "POSITION")
    private Integer position = 0;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive = Boolean.TRUE;
}
