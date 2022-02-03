package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    /**
     * jpa基本使用方法
     *
     * @param username
     * @return
     */
    AdUser findByUsername(String username);
}
