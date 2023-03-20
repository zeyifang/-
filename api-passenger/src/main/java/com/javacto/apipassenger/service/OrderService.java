package com.javacto.apipassenger.service;

import com.javacto.apipassenger.remote.ServiceOrderClient;
import com.javacto.internalcommon.constant.IdentityConstants;
import com.javacto.internalcommon.dto.OrderInfo;
import com.javacto.internalcommon.dto.ResponseResult;
import com.javacto.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult add(OrderRequest orderRequest){
        return serviceOrderClient.add(orderRequest);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    public ResponseResult cancel(Long orderId){
        return serviceOrderClient.cancel(orderId, IdentityConstants.PASSENGER_IDENTITY);
    }


    public ResponseResult<OrderInfo> detail(Long orderId){
        return serviceOrderClient.detail(orderId);
    }

    public ResponseResult<OrderInfo> currentOrder(String phone , String identity){
        return serviceOrderClient.current(phone,identity);
    }
}
