package com.itmuch.cloud.provider.dao;

import com.itmuch.cloud.provider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/9/20.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
