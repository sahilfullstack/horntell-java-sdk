package com.owlgrin.horntell.controller;

import com.owlgrin.horntell.util.Util;

/**
 * Created by dave on 14/11/15.
 */
public class Horntell {

    public static String basicAuth;

    public Horntell(String key, String secret){
        this.basicAuth = Util.getBasicAuthCredentials(key,secret);
    }

    public Horntell(String basicAuth){
        this.basicAuth = basicAuth;
    }

    public ProfileApi profile(){
        return new ProfileApi();
    }

    public HornApi horns(){ return new HornApi(); }

    public CampaignApi campaigns(){return  new CampaignApi(); }

}
