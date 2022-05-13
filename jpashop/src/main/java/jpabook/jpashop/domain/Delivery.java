package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
    private String street;
    private String zipcode;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
