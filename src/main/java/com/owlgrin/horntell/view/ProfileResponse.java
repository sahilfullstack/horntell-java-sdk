package com.owlgrin.horntell.view;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by dave on 14/11/15.
 */
public class ProfileResponse {

    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private Map custom_attributes;
    private String app_id;
    private Long signedup_at;


    private String avatar_url;
    private String position;
    private String company;
    private String industry;
    private String location;
    private String headline;
    private String birthday;
    private Map<String, Object> campaigns_summary;
    private Long last_seen_at;
    private Long created_at;
    private Map stats;
    private ArrayList<String> segments;
    private String uid;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map getCustom_attributes() {
        return custom_attributes;
    }

    public void setCustom_attributes(Map custom_attributes) {
        this.custom_attributes = custom_attributes;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Long getSignedup_at() {
        return signedup_at;
    }

    public void setSignedup_at(Long signedup_at) {
        this.signedup_at = signedup_at;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getCampaigns_summary() {
        return campaigns_summary;
    }

    public void setCampaigns_summary(Map<String, Object> campaigns_summary) {
        this.campaigns_summary = campaigns_summary;
    }

    public Long getLast_seen_at() {
        return last_seen_at;
    }

    public void setLast_seen_at(Long last_seen_at) {
        this.last_seen_at = last_seen_at;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public Map getStats() {
        return stats;
    }

    public void setStats(Map stats) {
        this.stats = stats;
    }

    public ArrayList<String> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<String> segments) {
        this.segments = segments;
    }
}
