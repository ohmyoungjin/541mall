package api.mall.repository;

import api.mall.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Member findOne(Long id);

    List<Member> findByUser(String name);

    List<Member> findAll();

    Optional<Member> findByLoginId(String loginId);
}
