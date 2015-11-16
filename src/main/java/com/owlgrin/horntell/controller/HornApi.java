package com.owlgrin.horntell.controller;

import com.owlgrin.horntell.exception.HorntellException;
import com.owlgrin.horntell.model.Horn;
import com.owlgrin.horntell.enums.RequestEndpoint;
import com.owlgrin.horntell.net.RequestUtil;

import java.io.IOException;

/**
 * Created by dave on 16/11/15.
 */
public class HornApi {

    public Boolean to_profile(String profile_id, Horn horn) throws IOException, HorntellException {
        return (new RequestUtil<Horn>().sendRequest(horn, RequestEndpoint.CREATE_HORN.setEndpoint(RequestEndpoint.CREATE_HORN.getEndpoint().replace("{id}", profile_id)))).getStatusLine().getStatusCode() == 204;
    }

}
