package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")//对应数据库表中的ad_user
public class AdUser {

    //由于是一个自增字段，所以我们在存储aduser的时候不需要用到这个字段
    @Id//标志成一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//使用主键自增策略
    @Column(name = "id",nullable = false)//设置对应数据表的字段，且不允许为空
    private Long id;

    @Basic//和Basic相对应的一个注解是@Transient，表示这个下面这个变量不与数据库表中对应，只是用在代码中其他地方
    @Column(name = "token", nullable = false)
    private String token;

    @Basic
    @Column(name = "user_name", nullable = false)
    private String username;

    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdUser(String token, String username) {
        this.token = token;
        this.username = username;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
