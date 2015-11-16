package com.owlgrin.horntell.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dave on 16/11/15.
 */
public class Campaign {

    protected ArrayList<String> profile_ids ;

    protected Map<String,String> meta ;

    public Campaign(Builder builder) {
        this.profile_ids= builder.profile_ids;
        this.meta = builder.meta;
    }

    public static class Builder {
        protected ArrayList<String> profile_ids = new ArrayList<String>();
        protected Map<String,String> meta = new HashMap<String, String>() ;

        public Builder addProfileUid(String uid){
            profile_ids.add(uid);
            return this;
        }

        public Builder addMetaData(String key, String value){
            meta.put(key, value);
            return this;
        }

        public Campaign build(){
            return new Campaign(this);
        }


    }


}
