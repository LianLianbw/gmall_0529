package com.atguigu.gmall.manager.mapper;

import com.atguigu.gmall.user.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface UserMapper extends BaseMapper<User> {

    /**
     * 测试再mapper文件下
     * */
    public User getUserByIdc(User user);
}
