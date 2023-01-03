package api.mall.repository;

import api.mall.domain.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    Member findOne(Long id);

    List<Member> findByName(String name);

    List<Member> findAll();
}
