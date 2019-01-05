package com.jp.zpzc.controller.file;

import com.jp.common.pay.dto.OrderRequest;
import com.jp.common.pay.service.IPayService;
import com.jp.framework.common.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yangfeng
 * @Date: 2018/9/27
 * @Description: 简测
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    private static Logger LOG = LoggerFactory.getLogger(PayController.class);


    @Resource
    private IPayService payService;


    /**
     * 付款
     *
     * @param openid       用户openid
     * @param body         商品描述信息
     * @param tradeType    交易类型 小程序取值如下：JSAPI  APP--app支付
     * @param payType      支付类型 1：购买 2：捐赠
     * @param purchaseType 购买类型 1：商品 2：项目
     * @return
     */
    @RequestMapping("/payment")
    public Object payment(@RequestBody OrderRequest orderRequest, String openid, String body, String tradeType, Integer payType, Integer purchaseType, String orderNumber, HttpServletRequest request) {
        return payService.payment(orderRequest, null, openid, body, tradeType, payType, purchaseType, IPUtil.getIpAddr(request), orderNumber);
    }


}
