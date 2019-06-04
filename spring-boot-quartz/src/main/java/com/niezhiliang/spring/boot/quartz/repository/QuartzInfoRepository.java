package com.niezhiliang.spring.boot.quartz.repository;

import com.niezhiliang.spring.boot.quartz.domain.QuartzInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartzInfoRepository extends JpaRepository<QuartzInfo,Integer> {
    /**
     *  获取任务
     * @param groupId
     * @return
     */
    QuartzInfo findQuartzInfoByJobName(String groupId);

    /**
     * 通过状态查询出所有的待执行和暂停的任务
     * @param status
     * @return
     */
    List<QuartzInfo> findQuartzInfosByJobStatusNotIn(Integer status);
}
