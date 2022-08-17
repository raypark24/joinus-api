package eks.practice.joinus.repository;

import eks.practice.joinus.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);
}

//    List<Tutorial> findByTitleContaining(String title);
