package com.owlgrin.horntell;

import com.owlgrin.horntell.controller.Horntell;
import com.owlgrin.horntell.exception.HorntellException;
import com.owlgrin.horntell.model.Campaign;
import com.owlgrin.horntell.model.Horn;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by dave on 16/11/15.
 */
public class CampaignTestCase extends BaseTest {

    private static final Logger log = Logger.getLogger(HornTestCase.class.getName());

    protected static Horntell horntell;

    @Test
    public final void campaignToSingleProfile() throws IOException, HorntellException {

        Campaign campaign = new Campaign.Builder()
                .addMetaData("name", "Dave").build();

        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        Boolean isCampaignRunning = horntellApi.campaigns().to_profile("900533","56496ba09f17f6ba348b4567", campaign);

        Assert.assertTrue(isCampaignRunning);
    }

    @Test
    public final void campaignToMultipleProfiles() throws IOException, HorntellException {

        Campaign campaign = new Campaign.Builder()
                .addProfileUid("900533")
                .addMetaData("name", "Dave").build();

        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        Boolean isCampaignRunning = horntellApi.campaigns().to_profiles("56496ba09f17f6ba348b4567", campaign);

        Assert.assertTrue(isCampaignRunning);
    }



}
