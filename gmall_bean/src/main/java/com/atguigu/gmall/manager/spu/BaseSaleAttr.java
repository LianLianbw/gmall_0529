package com.atguigu.gmall.manager.spu;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 基本销售属性
 */
@Data
public class BaseSaleAttr implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;//基本销售属性名
}
