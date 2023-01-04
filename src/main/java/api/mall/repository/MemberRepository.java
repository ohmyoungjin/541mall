package api.mall.repository;

import api.mall.domain.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    Member findOne(Long id);

    List<Member> findByUser(String name);

    List<Member> findAll();
}
