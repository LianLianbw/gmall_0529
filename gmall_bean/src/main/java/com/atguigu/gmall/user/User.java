package com.atguigu.gmall.user;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer delFlag; //自动有驼峰命名规则
}
