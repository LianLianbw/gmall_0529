package com.atguigu.gmall.user;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class BaseCatalog1 implements Serializable{
    @Id
    private String id;

    private String name;
}
