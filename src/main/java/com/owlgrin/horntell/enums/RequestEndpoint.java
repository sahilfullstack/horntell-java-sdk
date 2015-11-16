package com.owlgrin.horntell.enums;

/**
 * Created by dave on 15/11/15.
 */
public enum RequestEndpoint {

    CREATE_PROFILE("/profiles", RequestMethod.POST),
    UPDATE_PROFILE("/profiles/{id}", RequestMethod.PUT),
    GET_PROFILE("/profiles/{id}", RequestMethod.GET),
    DELETE_PROFILE("/profiles/{id}", RequestMethod.DELETE),


    CREATE_HORN("/profiles/{id}/horns", RequestMethod.POST),


    RUN_CAMPAIGN_TO_SINGLE_PROFILE("/profiles/{uid}/campaigns/{campaign_id}", RequestMethod.POST),
    RUN_CAMPAIGN_TO_MULTIPLE_PROFILEs("/profiles/campaigns/{campaign_id}", RequestMethod.POST);

    String endpoint;
    RequestMethod method;

    public String getEndpoint() {
        return endpoint;
    }

    public RequestEndpoint setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    private RequestEndpoint(String endpoint,RequestMethod method){
        this.endpoint = endpoint;
        this.method = method;
    }

    public String toString(){
        return endpoint;
    }


}
