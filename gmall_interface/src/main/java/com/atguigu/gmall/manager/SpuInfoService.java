package com.atguigu.gmall.manager;

import com.atguigu.gmall.manager.spu.BaseSaleAttr;
import com.atguigu.gmall.manager.spu.SpuImage;
import com.atguigu.gmall.manager.spu.SpuInfo;

import java.util.List;

public interface SpuInfoService {
    public List<SpuInfo> getSpuInfoById(Integer catalog3Id);

    public List<BaseSaleAttr> getBaseSaleAttr();

    public void saveBigSpuInfo(SpuInfo spuInfo);

    /**
     * 查询spu的所有图片,以供选择
     * @param spuId
     * @return
     */
    List<SpuImage> getSpuImage(Integer spuId);
}
