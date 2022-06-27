package study.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() throws Exception {
        //given
        Member member = new Member("memberA");
        //when
        Member saveMember = memberJpaRepository.save(member);
        //then
        Member findMember = memberJpaRepository.find(saveMember.getId());

        Assertions.assertEquals(saveMember.getId(), findMember.getId());
        Assertions.assertEquals(saveMember.getUsername(), findMember.getUsername());
    }

    @Test
    public void basicCRUD() throws Exception {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        //단건 조회 겸
        Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
        Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
        assertEquals(member1, findMember1);
        assertEquals(member2, findMember2);

        //리스트 조회 검증
        List<Member> all = memberJpaRepository.findAll();
        assertEquals(2, all.size());

        //카운트 검증
        assertEquals(2, memberJpaRepository.count());
    }

    @Test
    public void findByUsernameAndAgeGreaterThen() throws Exception {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberJpaRepository.save(m1);
        memberJpaRepository.save(m2);

        List<Member> result = memberJpaRepository.findByUsernameAndAgeGreaterThen("AAA", 15);

        assertEquals("AAA", result.get(0).getUsername());
        assertEquals(20, result.get(0).getAge());
        assertEquals(1, result.size());
    }

    @Test
    public void paging() throws Exception {
        // given
        memberJpaRepository.save(new Member("member1", 10));
        memberJpaRepository.save(new Member("member2", 10));
        memberJpaRepository.save(new Member("member3", 10));
        memberJpaRepository.save(new Member("member4", 10));
        memberJpaRepository.save(new Member("member5", 10));

        int page = 1;

        int age = 10;
        int limit = 3;
        int offset = page * limit;

        long totalCount = memberJpaRepository.totalCount(age);
        long totalPage = (int) Math.ceil((double) totalCount / limit);

        boolean isFirstPage = page == 0 ? true : false;
        boolean isLastPage = totalPage - 1 == page ? true : false;

        // when
        List<Member> members = memberJpaRepository.findByPage(age, offset, limit);

        System.out.println("page = " + page);
        System.out.println("age = " + age);
        System.out.println("limit = " + limit);
        System.out.println("offset = " + offset);
        System.out.println("totalCount = " + totalCount);
        System.out.println("totalPage = " + totalPage);
        System.out.println("isFirstPage = " + isFirstPage);
        System.out.println("isLastPage = " + isLastPage);

        // 페이지 계산 공식 적용...
        // totalPage = totalCount / size ...
        // 마지막 페이지 ..
        // 최초 페이지 ..

        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }
}