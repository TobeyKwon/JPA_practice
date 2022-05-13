package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberProduct {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
