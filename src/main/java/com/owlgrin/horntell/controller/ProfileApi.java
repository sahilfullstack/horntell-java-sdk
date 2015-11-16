package com.owlgrin.horntell.controller;

import com.owlgrin.horntell.exception.HorntellException;
import com.owlgrin.horntell.model.Profile;
import com.owlgrin.horntell.enums.RequestEndpoint;
import com.owlgrin.horntell.net.ResponseUtil;
import com.owlgrin.horntell.net.RequestUtil;
import com.owlgrin.horntell.view.ProfileResponse;

import java.io.IOException;

/**
 * Created by dave on 14/11/15.
 */
public class ProfileApi {


    public ProfileResponse create(Profile profile) throws IOException, HorntellException {
       return new ResponseUtil<ProfileResponse>().handleResponse(new RequestUtil<Profile>().sendRequest(profile, RequestEndpoint.CREATE_PROFILE), ProfileResponse.class);
    }

    public ProfileResponse update(String uid, Profile profile) throws IOException, HorntellException {
        return new ResponseUtil<ProfileResponse>().handleResponse(new RequestUtil<Profile>().sendRequest(profile, RequestEndpoint.UPDATE_PROFILE.setEndpoint(RequestEndpoint.UPDATE_PROFILE.getEndpoint().replace("{id}", uid))), ProfileResponse.class);
    }

    public ProfileResponse update(Profile profile) throws IOException, HorntellException {
        if(profile.getUid() == null || "".equals(profile.getUid()))
            throw new HorntellException("UId Missing",404, "Bad Request");

        return new ResponseUtil<ProfileResponse>().handleResponse(new RequestUtil<Profile>().sendRequest(profile, RequestEndpoint.UPDATE_PROFILE.setEndpoint(RequestEndpoint.UPDATE_PROFILE.getEndpoint().replace("{id}", profile.getUid()))), ProfileResponse.class);
    }

    public ProfileResponse get(String uid) throws IOException, HorntellException {
        return new ResponseUtil<ProfileResponse>().handleResponse(new RequestUtil<Profile>().sendRequest(null, RequestEndpoint.UPDATE_PROFILE.setEndpoint(RequestEndpoint.GET_PROFILE.getEndpoint().replace("{id}", uid))), ProfileResponse.class);
    }

    public boolean delete(String uid) throws IOException, HorntellException {
        return (new RequestUtil<Profile>().sendRequest(null, RequestEndpoint.UPDATE_PROFILE.setEndpoint(RequestEndpoint.DELETE_PROFILE.getEndpoint().replace("{id}", uid)))).getStatusLine().getStatusCode() == 204;
    }



}
