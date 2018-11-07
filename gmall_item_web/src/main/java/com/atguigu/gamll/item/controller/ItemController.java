package com.atguigu.gamll.item.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.SkuEsService;
import com.atguigu.gmall.manager.SkuService;
import com.atguigu.gmall.manager.sku.SkuAttrValueMappingTo;
import com.atguigu.gmall.manager.sku.SkuInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Reference
    SkuService skuService;

    @RequestMapping("/{skuId}.html")
    public String itemPage(@PathVariable("skuId") Integer skuId, Model model) throws InterruptedException {
        //1、查出sku的详细信息

        SkuInfo skuInfo = skuService.getSkuInfoBySkuId(skuId);
        model.addAttribute("skuInfo",skuInfo);

        Integer spuId = skuInfo.getSpuId();
        //2、查出当前sku对应的spu下面所有sku销售属性值的组合
        List<SkuAttrValueMappingTo> valueMappingToList = skuService.getSkuAttrValueMapping(spuId);
        model.addAttribute("skuValueMapping",valueMappingToList);

        //3、增加点击率；更新es的hotScore值
        //redis  把redis中这个商品的热度保存起来增加即可
        skuService.incrSkuHotScore(skuId);
        return "item";
    }
}
