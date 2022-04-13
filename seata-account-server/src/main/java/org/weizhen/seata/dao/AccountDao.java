package org.weizhen.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    /**
     * 减少对应用户的钱
     * @param userId
     * @param reduction
     * @return
     */
    int decrease(@Param("userId") Long userId,@Param("reduction") BigDecimal reduction);
}
