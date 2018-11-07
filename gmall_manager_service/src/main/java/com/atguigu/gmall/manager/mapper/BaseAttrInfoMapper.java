package com.atguigu.gmall.manager.mapper;

import com.atguigu.gmall.user.BaseAttrInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    public Integer insertAndReturnId(BaseAttrInfo baseAttrInfo);

    /**
     * 按照三级分类id查出平台属性的名和值
     * @param catalog3Id
     * @return
     */
    List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(Integer catalog3Id);

    List<BaseAttrInfo> getBaseAttrInfoGroupByValueId(@Param("valueIds") List<Integer> valueIds);
}
