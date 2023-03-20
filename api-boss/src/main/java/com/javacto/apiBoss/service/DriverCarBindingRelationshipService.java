package com.javacto.apiBoss.service;

import com.javacto.apiBoss.remote.ServiceDriverUserClient;
import com.javacto.internalcommon.dto.DriverCarBindingRelationship;
import com.javacto.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverCarBindingRelationshipService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;


    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship){
        return serviceDriverUserClient.bind(driverCarBindingRelationship);
    }

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship) {

        return serviceDriverUserClient.unbind(driverCarBindingRelationship);
    }
}
