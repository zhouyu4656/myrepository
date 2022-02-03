package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit_keyword")
public class AdUnitKeyWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id", nullable = false)
    private Integer unitId;

    @Basic
    @Column(name = "key_word", nullable = false)
    private String keyWord;

    public AdUnitKeyWord(Integer unitId, String keyWord) {
        this.unitId = unitId;
        this.keyWord = keyWord;
    }
}
