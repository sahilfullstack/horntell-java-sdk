package com.owlgrin.horntell.model;

import java.util.Map;

/**
 * Created by dave on 15/11/15.
 */
public class Trigger {

    private String type;
    private String id;
    private Map<String,String> meta;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }
}
