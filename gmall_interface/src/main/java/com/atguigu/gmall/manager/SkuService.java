package com.atguigu.gmall.manager;

import com.atguigu.gmall.manager.es.SkuBaseAttrEsVo;
import com.atguigu.gmall.manager.sku.SkuAttrValueMappingTo;
import com.atguigu.gmall.manager.sku.SkuInfo;
import com.atguigu.gmall.manager.spu.SpuSaleAttr;
import com.atguigu.gmall.user.BaseAttrInfo;

import java.util.List;

/**
 * Sku服务组件
 */
public interface SkuService  {

    List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(Integer catalog3Id);

    /**
     *按照spuId查询出这个spu对应的所有的销售属性的名和值
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrBySpuId(Integer spuId);

    void saveBigSkuInfo(SkuInfo skuInfo);

    /**
     * 获取spu对应的skuInfo
     * @param spuId
     * @return
     */
    List<SkuInfo> getSkuInfoBySpuId(Integer spuId);

    SkuInfo getSkuInfoBySkuId(Integer skuId) throws InterruptedException;

    List<SkuAttrValueMappingTo> getSkuAttrValueMapping(Integer spuId);

    /**
     * 查出当前sku的所有平台属性的值
     * @param skuId
     * @return
     */
    List<SkuBaseAttrEsVo> getSkuBaseAttrValueIds(Integer skuId);

    List<BaseAttrInfo> getBaseAttrInfoGroupByValueId(List<Integer> valueIds);

    void incrSkuHotScore(Integer skuId);
}
