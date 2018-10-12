package com.atguigu.gmall.manager.mapper;

import com.atguigu.gmall.user.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    public Integer insertAndReturnId(BaseAttrInfo baseAttrInfo);
}
