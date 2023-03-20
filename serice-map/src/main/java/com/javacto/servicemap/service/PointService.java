package com.javacto.servicemap.service;

import com.javacto.internalcommon.dto.ResponseResult;
import com.javacto.internalcommon.request.PointRequest;
import com.javacto.servicemap.remote.PointClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest){

        return pointClient.upload(pointRequest);
    }
}
