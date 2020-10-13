package com.neo.repository;

import com.neo.model.User;
import com.neo.model.projection.SimpleUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author wangmaoshuai
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * 通过id获取
     *
     * @param id
     * @return
     */
    @Override
    Optional<User> findById(String id);

    /**
     * 通过userName查询
     *
     * @param userName
     * @return
     */
    @EntityGraph(attributePaths = {"workCompanies"})
    Optional<User> findAllByUserName(String userName);

    /**
     * 通过id删除
     *
     * @param id
     */
    @Override
    void deleteById(String id);

    /**
     * 通过用户名获取用户的基本信息
     *
     * @param userName
     * @return
     */
    List<SimpleUser> findByUserName(String userName);

    /**
     * 根据工作地获取员工相关信息
     *
     * @param workPlace 工作地
     * @return 返回数据组合
     */
    @Query("select concat(u.userName,'/n',u.age) " +
            "from jpa_user u join u.workCompanies c " +
            "where c.address like :#{#workPlace==null || #workPlace.isEmpty() ? '1=1' : '%'+#workPlace+'%' }")
    List<String> findSimpleByWorkPlace(String workPlace);

    /**
     * 分页查询
     *
     * @param age
     * @param page
     * @param sort
     * @return
     */
    Page<User> findUserByAgeAfter(Integer age, Pageable page);
}