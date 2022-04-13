package org.weizhen.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.weizhen.springcloud.entities.Order;

@Mapper
public interface OrderDao {

    int create(Order order);

    int update(@Param(value = "userId") Long userId, @Param(value = "status") Integer status, @Param("id") Long id);
}
