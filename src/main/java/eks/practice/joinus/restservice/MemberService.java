package eks.practice.joinus.restservice;

import eks.practice.joinus.entity.Member;
import eks.practice.joinus.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member saveMember(Member member){
        return memberRepository.saveAndFlush(member);
    }
}
