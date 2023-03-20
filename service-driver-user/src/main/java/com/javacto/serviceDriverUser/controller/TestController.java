package com.javacto.serviceDriverUser.controller;

import com.javacto.internalcommon.dto.ResponseResult;
import com.javacto.serviceDriverUser.mapper.DriverUserMapper;
import com.javacto.serviceDriverUser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DriverUserService driverUserService;

    @GetMapping("/test")
    public String test(){
        return "service-driver-user";
    }

    @GetMapping("/test-db")
    public ResponseResult testDb(){
        return driverUserService.testGetDriverUser();
    }


    // 测试mapper中的xml是否正常使用
    @Autowired
    DriverUserMapper driverUserMapper;

    @GetMapping("/test-xml")
    public int testXml(String cityCode){
        int i = driverUserMapper.selectDriverUserCountByCityCode(cityCode);
        return i;
    }
}
