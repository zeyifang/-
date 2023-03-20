package com.javacto.servicemap.service;

import com.javacto.internalcommon.dto.ResponseResult;
import com.javacto.internalcommon.responese.TrackResponse;
import com.javacto.servicemap.remote.TrackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

    @Autowired
    TrackClient trackClient;

    public ResponseResult<TrackResponse> add(String tid){

        return trackClient.add(tid);
    }
}
