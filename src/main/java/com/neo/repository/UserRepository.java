package com.neo.repository;

import com.neo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author wangmaoshuai
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * 通过id获取
     * @param id
     * @return
     */
    @Override
    Optional<User> findById(String id);

    /**
     * 通过userName查询
     * @param userName
     * @return
     */
    @EntityGraph(attributePaths = {"workCompanies"})
    Optional<User> findAllByUserName(String userName);
    /**
     * 通过id删除
     * @param id
     */
    @Override
    void deleteById(String id);
}