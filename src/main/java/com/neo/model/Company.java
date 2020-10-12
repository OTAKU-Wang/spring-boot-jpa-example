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

/**
 * @author wangmaoshuai
 */
@Data
@Accessors(chain = true)
@Entity(name = "jpa_company")
@EntityListeners(AuditingEntityListener.class)
public class Company {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phoneNum;
    @CreatedDate
    @Column(nullable = false)
    private Date createTime;
    @LastModifiedDate
    @Column(nullable = false)
    private Date modifyTime;
    @CreatedBy
    private String createBy;
}
