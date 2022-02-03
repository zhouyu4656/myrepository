package com.imooc.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_creative")
public class Creative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "type", nullable = false)
    private String type;

    /**
     * masterialType广告创意物料的类型，比如图片可以是jpg bmp等等
     */
    @Basic
    @Column(name = "masterial_type", nullable = false)
    private Integer masterialType;

    @Basic
    @Column(name = "height", nullable = false)
    private Integer height;

    @Basic
    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Basic
    @Column(name = "size", nullable = false)
    private Long size;

    /**
     * 持续时常，只有视频不为0
     */
    @Basic
    @Column(name = "duration", nullable = false)
    private Integer duration;

    /**
     * 审核状态
     */
    @Basic
    @Column(name = "audit_status", nullable = false)
    private Integer auditStatus;

    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "url", nullable = false)
    private String url;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

}
