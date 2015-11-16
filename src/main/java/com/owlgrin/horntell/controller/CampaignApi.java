package com.owlgrin.horntell.controller;

import com.owlgrin.horntell.exception.HorntellException;
import com.owlgrin.horntell.enums.RequestEndpoint;
import com.owlgrin.horntell.model.Campaign;
import com.owlgrin.horntell.net.RequestUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by dave on 16/11/15.
 */
public class CampaignApi {

    public boolean to_profile(String uid, String campaign_id, Campaign campaign) throws IOException, HorntellException {
        return (new RequestUtil<Campaign>().sendRequest(campaign, RequestEndpoint.RUN_CAMPAIGN_TO_SINGLE_PROFILE.setEndpoint(RequestEndpoint.RUN_CAMPAIGN_TO_SINGLE_PROFILE.getEndpoint().replace("{uid}", uid).replace("{campaign_id}",campaign_id)))).getStatusLine().getStatusCode() ==204;
    }

    public boolean to_profiles(String campaign_id, Campaign campaign) throws IOException, HorntellException {
        return (new RequestUtil<Campaign>().sendRequest(campaign, RequestEndpoint.RUN_CAMPAIGN_TO_MULTIPLE_PROFILEs.setEndpoint(RequestEndpoint.RUN_CAMPAIGN_TO_MULTIPLE_PROFILEs.getEndpoint().replace("{campaign_id}",campaign_id)))).getStatusLine().getStatusCode() ==204;
    }
}
