package com.boot.demo.dao;


import com.boot.demo.entity.UserAgeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-8 09:41:07
 */
@Repository
public interface UserAgeDao {


    //通过 年份 获取所有线路的用户年龄结构
    public List<UserAgeEntity> getAllLineUserAgeByYear(@Param("year") Integer year);

    //通过 线路 年份 获取该线路的用户年龄结构
    public UserAgeEntity getSingleLineUserAgeByYearAndLine(@Param("year") Integer year,@Param("line") String line);

    public List<UserAgeEntity> getStationUserAgeByYearAndLine(@Param("year") Integer year,@Param("line") String line);
}
