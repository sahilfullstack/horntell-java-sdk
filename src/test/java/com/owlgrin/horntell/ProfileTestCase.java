package com.owlgrin.horntell;

import com.owlgrin.horntell.controller.Horntell;
import com.owlgrin.horntell.exception.HorntellException;
import com.owlgrin.horntell.model.Profile;
import com.owlgrin.horntell.view.ProfileResponse;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;


/**
 * Created by dave on 14/11/15.
 */


public class ProfileTestCase extends BaseTest{

    private static final Logger log = Logger.getLogger(ProfileTestCase.class.getName());

    protected static Horntell horntellApi;
    private static String savedUid;

    @Test
    public final void createProfileSuccessTest() throws IOException, HorntellException {
        Profile profile = new Profile.Builder()
                .setApp_id("123456")
                .setEmail("abcd@xyz.com")
                .setFirst_name("Dave")
                .setLast_name("Ranjan")
                .setGender("male")
                .setSignedup_at(1236547852L)
                .setUid(String.valueOf(((Double) (Math.random() * 1000000)).intValue()))
                .build();

        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        ProfileResponse profileResponse = horntellApi.profile().create(profile);

        Assert.assertNotNull(profileResponse);

        savedUid = profileResponse.getUid();
    }

    @Test
    public final void updateProfileSuccessTest() throws IOException, HorntellException {
        Profile profile = new Profile.Builder()
                .setApp_id("123456")
                .setEmail("abcd@xyz.com")
                .setSignedup_at(1236547852L)
                .setUid(savedUid)
                .build();

        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        ProfileResponse profileResponse = horntellApi.profile().update(savedUid, profile);

        Assert.assertNotNull(profileResponse);

        savedUid = profileResponse.getUid();
    }

    @Test
    public final void updateProfileOverloadedSuccessTest() throws IOException, HorntellException {
        Profile profile = new Profile.Builder()
                .setApp_id("123456")
                .setEmail("abcde@xyz.com")
                .setSignedup_at(1236547852L)
                .setUid(savedUid)
                .build();

        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        ProfileResponse profileResponse = horntellApi.profile().update(profile);

        Assert.assertNotNull(profileResponse);

        savedUid = profileResponse.getUid();
    }

    @Test
    public final void getProfileOverloadedSuccessTest() throws IOException, HorntellException {
        Profile profile = new Profile.Builder()
                .setApp_id("123456")
                .setEmail("abcde@xyz.com")
                .setSignedup_at(1236547852L)
                .setUid(savedUid)
                .build();

        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        ProfileResponse profileResponse = horntellApi.profile().get(savedUid);

        Assert.assertNotNull(profileResponse);

        savedUid = profileResponse.getUid();
    }

}
