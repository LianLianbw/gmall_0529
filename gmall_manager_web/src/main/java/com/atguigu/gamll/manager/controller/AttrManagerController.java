package com.atguigu.gamll.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.manager.ManageService;
import com.atguigu.gmall.user.BaseAttrInfo;
import com.atguigu.gmall.user.BaseCatalog1;
import com.atguigu.gmall.user.BaseCatalog2;
import com.atguigu.gmall.user.BaseCatalog3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class AttrManagerController {

    @Reference
    ManageService manageService;

    @RequestMapping(value = "attrListPage")
    public String getAttrListPage() {
        return "attrListPage";
    }

    /***
     * 获得一级分类
     *
     * @return
     */
    @RequestMapping(value="getCatalog1",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCatalog1() {
        List<BaseCatalog1> catalog1List = manageService.getCatalog1();
        String catalog1Json = JSON.toJSONString(catalog1List);
        return catalog1Json;
    }

    /***
     * 获得二级分类
     *
     * @param map
     * @return
     */
    @RequestMapping(value="getCatalog2",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCatalog2(@RequestParam Map<String, String> map) {
        String catalog1Id = map.get("catalog1Id");
        List<BaseCatalog2> catalog2List = manageService.getCatalog2(catalog1Id);
        String catalog2Json = JSON.toJSONString(catalog2List);
        return catalog2Json;
    }

    /***
     * 获得三级分类
     *
     * @param map
     * @return
     */
    @RequestMapping(value="getCatalog3",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCatalog3(@RequestParam Map<String, String> map) {
        String catalog2Id = map.get("catalog2Id");
        List<BaseCatalog3> catalog3List = manageService.getCatalog3(catalog2Id);
        String catalog3Json = JSON.toJSONString(catalog3List);
        return catalog3Json;
    }

    /***
     * 获得属性列表
     *
     * @param map
     * @return
     */
    @RequestMapping(value="getAttrList",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAttrList(@RequestParam Map<String, String> map) {
        String catalog3Id = map.get("catalog3Id");
        List<BaseAttrInfo> attrList = manageService.getAttrList(catalog3Id);
        String attrListJOSN = JSON.toJSONString(attrList);
        return attrListJOSN;
    }


    @RequestMapping(value = "getAttrValueList",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAttrValueList(@RequestParam Map<String,String> map){
        String attrId= map.get("attrId");
        BaseAttrInfo attrInfo = manageService.getAttrInfo(attrId);
        String attrInfoJOSN = JSON.toJSONString(attrInfo.getAttrValueList());
        return attrInfoJOSN;
    }

    @RequestMapping(value = "saveAttrInfo",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveAttrInfo(BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
        return "success";
    }

    @RequestMapping(value = "deleteInfo",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteInfo(String catalog3Id) {
        manageService.deleteInfo(catalog3Id);
        return "success";
    }
}