package com.atguigu.gmall.user;

public interface UserInfoService {
    /**
     * userInfo 按照密码和账号查询用户的详情
     * return 返回用户再数据库的详细信息
     * */
    public UserInfo login(UserInfo userInfo);

    
}
