package study.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import study.datajpa.entity.Member;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public Page<MemberDto> toDtoList(Page<Member> memberList) {
        return memberList.map(m -> new MemberDto(m.getId(), m.getUsername(), m.getTeam().getName()));
    }
}
