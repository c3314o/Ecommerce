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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * User.
 *
 * @author Jakub Polák
 */
@Data
@ToString(exclude = {"customerOrders", "userGroup"})
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<CustomerOrder> customerOrders;

    @ManyToOne
    @JoinColumn(name = "USER_GROUP_ID", referencedColumnName = "ID")
    private UserGroup userGroup;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @Column(name = "SALT", nullable = false, length = 50)
    private String salt;

    @Column(name = "PHONE", length = 50)
    private String phone;

    @Column(name = "BILLING_FIRST_NAME", length = 50)
    private String billingFirstName;

    @Column(name = "BILLING_LAST_NAME", length = 50)
    private String billingLastName;

    @Column(name = "BILLING_STREET_NAME", length = 100)
    private String billingStreetName;

    @Column(name = "BILLING_STREET_NUMBER", length = 20)
    private String billingStreetNumber;

    @Column(name = "BILLING_CITY", length = 50)
    private String billingCity;

    @Column(name = "BILLING_POSTAL_CODE", length = 50)
    private String billingPostalCode;

    @Column(name = "BILLING_COUNTRY", length = 100)
    private String billingCountry;

    @Column(name = "BILLING_COMPANY_NAME", length = 100)
    private String billingCompanyName;

    @Column(name = "BILLING_COMPANY_ICO", length = 20)
    private String billingCompanyIco;

    @Column(name = "BILLING_COMPANY_DIC", length = 20)
    private String billingCompanyDic;

    @Column(name = "DELIVERY_COMPANY_NAME", length = 50)
    private String deliveryCompanyName;

    @Column(name = "DELIVERY_FIRST_NAME", length = 50)
    private String deliveryFirstName;

    @Column(name = "DELIVERY_LAST_NAME", length = 50)
    private String deliveryLastName;

    @Column(name = "DELIVERY_STREET_NAME", length = 100)
    private String deliveryStreetName;

    @Column(name = "DELIVERY_STREET_NUMBER", length = 50)
    private String deliveryStreetNumber;

    @Column(name = "DELIVERY_CITY", length = 100)
    private String deliveryCity;

    @Column(name = "DELIVERY_POSTAL_CODE", length = 50)
    private String deliveryPostalCode;

    @Column(name = "DELIVERY_COUNTRY", length = 100)
    private String deliveryCountry;

    @Column(name = "IS_EMAIL_CONFIRMED", nullable = false)
    private Boolean isEmailConfirmed = Boolean.FALSE;
}
