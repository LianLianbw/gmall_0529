package com.atguigu.gmall.user;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable{

    @Id
    private String id;

    private String attrName;

    private String catalog3Id;

    @Transient
    private List<BaseAttrValue> attrValueList;
}
