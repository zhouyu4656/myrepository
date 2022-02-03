package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "creative_unit")
public class CreativeUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id", nullable = false)
    private String unitId;

    @Basic
    @Column(name = "creative_id", nullable = false)
    private String creativeId;

    public CreativeUnit(String unitId, String creativeId) {
        this.unitId = unitId;
        this.creativeId = creativeId;
    }
}
