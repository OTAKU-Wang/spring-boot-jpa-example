package com.neo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author wangmaoshuai
 */
@Data
@Accessors(chain = true)
@Entity(name = "jpa_user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int age;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "jpa_user_work_company", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "id")})
    private List<Company> workCompanies;
    @CreatedDate
    @Column(nullable = false)
    private Date createTime;
    @LastModifiedDate
    @Column(nullable = false)
    private Date modifyTime;
    @CreatedBy
    private String createBy;
}
