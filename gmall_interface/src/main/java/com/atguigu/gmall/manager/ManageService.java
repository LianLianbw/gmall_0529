package com.atguigu.gmall.manager;

import com.atguigu.gmall.user.BaseAttrInfo;
import com.atguigu.gmall.user.BaseCatalog1;
import com.atguigu.gmall.user.BaseCatalog2;
import com.atguigu.gmall.user.BaseCatalog3;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();

    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    public BaseAttrInfo getAttrInfo(String attrId);

    public void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    public void deleteInfo(String catalog3Id);
}
