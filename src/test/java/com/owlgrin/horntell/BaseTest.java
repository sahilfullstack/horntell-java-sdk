package com.owlgrin.horntell;

import com.owlgrin.horntell.util.Util;

/**
 * Created by dave on 15/11/15.
 */
public class BaseTest {

    protected static final String getBasicAuthCredentials(){
       /*
       Mohit's Credentials

       String key = "aDg5YnM7tEsQ7shT59mPGaQlTA3lTfkdHKOTjMhz";
        String secret = "m8lvcFEujSC0iZIKPIqaaVp11vofQVsyBi7dYyXf";*/

        String key = "d1soVNeGTbTHoAFKarI1vDIOQCvYljO3tsxs2yUy";
        String secret = "BdvuDEo5g6aeY9smQSlte4uxx9J361Nidx12SXOr";
        return Util.getBasicAuthCredentials(key, secret);
    }

}
