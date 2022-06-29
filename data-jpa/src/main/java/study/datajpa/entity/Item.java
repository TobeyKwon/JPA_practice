package study.datajpa.entity;

import lombok.Getter;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Item extends JpaBaseEntity implements Persistable<String> {

    @Id
    private String id;

    public Item(String id) {
        this.id = id;
    }

    public Item() {

    }

    @Override
    public boolean isNew() {
        return getCreatedDate() == null;
    }
}
