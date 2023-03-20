package com.javacto.apiDriver.service;

import com.javacto.apiDriver.remote.ServiceOrderClient;
import com.javacto.apiDriver.remote.ServiceSsePushClient;
import com.javacto.internalcommon.constant.IdentityConstants;
import com.javacto.internalcommon.dto.ResponseResult;
import com.javacto.internalcommon.request.OrderRequest;
import com.javacto.internalcommon.request.PushRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService {

    @Autowired
    ServiceSsePushClient serviceSsePushClient;

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult pushPayInfo(Long orderId, String price,Long passengerId){
        // 封装消息
        JSONObject message = new JSONObject();
        message.put("price",price);
        message.put("orderId",orderId);
        // 修改订单状态
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pushPayInfo(orderRequest);

        PushRequest pushRequest = new PushRequest();
        pushRequest.setContent(message.toString());
        pushRequest.setUserId(passengerId);
        pushRequest.setIdentity(IdentityConstants.PASSENGER_IDENTITY);

        // 推送消息
        serviceSsePushClient.push(pushRequest);

        return ResponseResult.success();
    }
}
