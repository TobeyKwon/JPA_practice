package study.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void MemberJpaRepositoryTest() throws Exception {
        //given
        Member member = new Member("memberA");
        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(saveMember.getId())
                .get();

        Assertions.assertEquals(saveMember.getId(), findMember.getId());
        Assertions.assertEquals(saveMember.getUsername(), findMember.getUsername());
    }
}
