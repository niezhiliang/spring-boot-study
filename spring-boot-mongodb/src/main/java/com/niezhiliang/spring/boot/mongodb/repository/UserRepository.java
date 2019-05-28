package com.niezhiliang.spring.boot.mongodb.repository;

import com.niezhiliang.spring.boot.mongodb.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午9:46
 */
public interface UserRepository extends PagingAndSortingRepository<User,String> {

    List<User> findAllBySex(String sex);
}
