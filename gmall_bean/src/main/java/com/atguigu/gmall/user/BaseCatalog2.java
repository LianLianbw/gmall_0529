package com.atguigu.gmall.user;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class BaseCatalog2 implements Serializable{
    @Id

    private String id;

    private String name;

    private String catalog1Id;
}
