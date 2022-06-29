package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.datajpa.entity.Item;

@SpringBootTest
public class ItemResitoryTest {

    @Autowired ItemRepository itemRepository;

    @Test
    public void save() throws Exception {
        Item item = new Item("aa");
        itemRepository.save(item);
    }
}
