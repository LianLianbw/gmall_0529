package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.annotation.LoginRequired;
import com.atguigu.gmall.cart.CartItem;
import com.atguigu.gmall.cart.CartService;
import com.atguigu.gmall.cart.CartVo;
import com.atguigu.gmall.order.TradePageVo;
import com.atguigu.gmall.user.UserAddress;
import com.atguigu.gmall.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/*
* 交易结算
* */
@Controller
public class TradeController {

    @Reference
    CartService cartService;

    @Reference
    UserService userService;

    @LoginRequired //必须登录
    @RequestMapping("/trade")
    public String trade(HttpServletRequest request){
        //1.判断用户选中的商品(验证商品)
        //1.1)获取到用户信息
        Map<String,Object> userInfo = (Map<String, Object>) request.getAttribute("userInfo");
        Integer id = (Integer) userInfo.get("id");
        //1.2)获取购物车被选中的商品
        List<CartItem> cartItemList = cartService.getCartInfoCheckedList(id);

        //2.查询和展示收货人信息
        List<UserAddress> UserAddresses = userService.getUserAddressesByUserId(id);


        //3.展示购物车信息

        TradePageVo vo = new TradePageVo();
        CartVo cartVo = new CartVo();
        cartVo.setCartItems(cartItemList);
        vo.setTotalPrice(cartVo.getTotalPrice());
        vo.setCartItems(cartItemList);
        vo.setUserAddresses(UserAddresses);


        //3.防止重复提交
        request.setAttribute("tradeInfo",vo);
        //跳到结算页面
        return "trade";
    }
}
