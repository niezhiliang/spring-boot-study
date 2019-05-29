package com.niezhiliang.spring.boot.jwt.repository;

import com.niezhiliang.spring.boot.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午11:36
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByAccount(String account);
}
