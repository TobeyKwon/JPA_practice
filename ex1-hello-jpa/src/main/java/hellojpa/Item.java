package hellojpa;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn
public abstract class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int price;
}
