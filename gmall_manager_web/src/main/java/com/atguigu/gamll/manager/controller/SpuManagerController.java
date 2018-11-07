package com.atguigu.gamll.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.SpuInfoService;
import com.atguigu.gmall.manager.spu.BaseSaleAttr;
import com.atguigu.gmall.manager.spu.SpuInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/spu")
public class SpuManagerController {

    @Reference
    SpuInfoService spuInfoService;

    @ResponseBody
    @RequestMapping("/bigSave")
    public String saveAllSpuInfo(@RequestBody SpuInfo spuInfo){
        log.info("页面提交的SpuInfo的数据如下：{}",spuInfo);
        try{
            spuInfoService.saveBigSpuInfo(spuInfo);
        }catch (Exception e){
            return "保存失败！！！";
        }
        return "ok";
    }

    /**
     * 返回所有的BaseSaleAttr对象信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/base_sale_attr")
    public List<BaseSaleAttr> getBaseSaleAttr(){
        return spuInfoService.getBaseSaleAttr();
    }


    @ResponseBody
    @RequestMapping("/info.json")
    public List<SpuInfo> getSpuInfoById(@RequestParam("catalog3Id") Integer catalog3Id){
        return spuInfoService.getSpuInfoById(catalog3Id);
    }

    @RequestMapping("/spuListPage")
    public String spuListPage(){
        return "spu/spuListPage";
    }
}
