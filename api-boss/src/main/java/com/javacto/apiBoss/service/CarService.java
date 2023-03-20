package com.javacto.apiBoss.service;

import com.javacto.apiBoss.remote.ServiceDriverUserClient;
import com.javacto.internalcommon.dto.Car;
import com.javacto.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addCar(Car car){
        return serviceDriverUserClient.addCar(car);
    }
}
