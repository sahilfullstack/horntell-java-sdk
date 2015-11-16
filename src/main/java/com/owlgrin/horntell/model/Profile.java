package com.owlgrin.horntell.model;

import java.util.Map;

/**
 * Created by dave on 15/11/15.
 */
public class Profile {

    protected String first_name;
    protected String last_name;
    protected String email;
    protected String gender;
    protected Map custom_attributes;
    protected String app_id;
    protected Long signedup_at;
    protected String uid;


    private Profile(Builder profileBuilder){
        this.first_name = profileBuilder.first_name;
        this.last_name=profileBuilder.last_name;
        this.email=profileBuilder.email;
        this.gender=profileBuilder.gender;
        this.custom_attributes = profileBuilder.custom_attributes;
        this.app_id=profileBuilder.app_id;
        this.signedup_at=profileBuilder.signedup_at;
        this.uid=profileBuilder.uid;

    }

    public String getUid(){
        return this.uid;
    }

    public static class Builder {

        protected String first_name;
        protected String last_name;
        protected String email;
        protected String gender;
        protected String birthday;
        protected Map custom_attributes;
        protected String app_id;
        protected Long signedup_at;
        protected String uid;

        public Builder setUid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public Builder setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder setCustom_attributes(Map custom_attributes) {
            this.custom_attributes = custom_attributes;
            return this;
        }

        public Builder setApp_id(String app_id) {
            this.app_id = app_id;
            return this;
        }

        public Builder setSignedup_at(Long signedup_at) {
            this.signedup_at = signedup_at;
            return this;
        }

        public Profile build(){
            return new Profile(this);
        }
    }
}
