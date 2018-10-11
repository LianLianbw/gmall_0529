package com.atguigu.gmall.manager;

import com.atguigu.gmall.manager.mapper.UserMapper;
import com.atguigu.gmall.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManagerServiceApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {

        for (User user : userMapper.selectList(null)) {
            System.out.println(user);
        }

        System.out.println("===========");
        User user = new User();
        user.setName("Jone");
        user.setAge(18);
        User userByIdc = userMapper.getUserByIdc(user);
        System.out.println(userByIdc);

    }

    @Test
    public void testDelete() {
        userMapper.deleteById(1L);
        //提示：只要javaBean中没有@TableLogic还是物理删除
        //自定义的xml方法不能使用到这个功能
    }

}
