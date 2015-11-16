package com.owlgrin.horntell.view;

import com.owlgrin.horntell.model.Trigger;

/**
 * Created by dave on 15/11/15.
 */
public class HornResponse {

    protected String id;
    protected String profile_id;
    protected Trigger trigger;
    protected String format;
    protected Boolean bubble;
    protected String type;
    protected String text;
    protected String html;
    protected Long delivered_at;
    protected Long seen_at;
    protected Long read_at;
    protected Long responded_at;
    protected String response;
    protected Long created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Boolean getBubble() {
        return bubble;
    }

    public void setBubble(Boolean bubble) {
        this.bubble = bubble;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Long getDelivered_at() {
        return delivered_at;
    }

    public void setDelivered_at(Long delivered_at) {
        this.delivered_at = delivered_at;
    }

    public Long getSeen_at() {
        return seen_at;
    }

    public void setSeen_at(Long seen_at) {
        this.seen_at = seen_at;
    }

    public Long getRead_at() {
        return read_at;
    }

    public void setRead_at(Long read_at) {
        this.read_at = read_at;
    }

    public Long getResponded_at() {
        return responded_at;
    }

    public void setResponded_at(Long responded_at) {
        this.responded_at = responded_at;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }
}
