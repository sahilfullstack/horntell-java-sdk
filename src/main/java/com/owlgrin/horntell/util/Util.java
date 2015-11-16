package com.owlgrin.horntell.util;

import com.owlgrin.horntell.controller.Horntell;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by dave on 14/11/15.
 */
public class Util {

   private static Log log = LogFactory.getLog(Util.class.getName());

    public static final String getBasicAuthCredentials(String key,String secret){
            String _credentials = key+":"+secret;
            _credentials = "Basic " + Base64.encodeBase64String(_credentials.getBytes());
            log.debug("Basic Auth credentials : "+_credentials);
            return _credentials;
    }

    public static final String getBasicAuthCredentials(){
        log.debug("Basic Auth credentials : "+ Horntell.basicAuth);
        return Horntell.basicAuth;
    }
}
