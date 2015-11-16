package com.owlgrin.horntell;

import com.owlgrin.horntell.controller.Horntell;
import com.owlgrin.horntell.exception.HorntellException;
import com.owlgrin.horntell.model.Horn;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;


/**
 * Created by dave on 14/11/15.
 */


public class HornTestCase extends BaseTest {

    private static final Logger log = Logger.getLogger(HornTestCase.class.getName());

    protected static Horntell horntell;

    @Test
    public final void createHornSuccessTest() throws IOException, HorntellException {
        Horn horn = new Horn.Builder()
                .setBubble(true)
                .setFormat("link")
                .setText("Welcome campaign was fired.")
                .setType("info")
                .setHtml("<strong>Welcome</strong> campaign was fired.")
                .setLink("http://app.example.com/campaigns/welcome")
                .setNew_window(true)
                .build();


        Horntell horntellApi = new Horntell(getBasicAuthCredentials());

        Boolean isHornSent = horntellApi.horns().to_profile("900533", horn);

        Assert.assertTrue(isHornSent);
    }
}
