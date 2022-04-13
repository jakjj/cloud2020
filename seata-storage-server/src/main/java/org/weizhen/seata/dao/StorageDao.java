package org.weizhen.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    int decrease(@Param("productId") Long productId, @Param("reduction") Integer reduction);
}
