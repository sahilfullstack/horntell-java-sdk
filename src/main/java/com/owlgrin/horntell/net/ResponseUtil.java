package com.owlgrin.horntell.net;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.owlgrin.horntell.exception.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by dave on 15/11/15.
 */
public class ResponseUtil<ResponseObject>  {

    Log log = LogFactory.getLog(ResponseUtil.class.getName());

    private String message;
    private String type;
    private Integer code;

    public final ResponseObject handleResponse(HttpResponse response, Class<ResponseObject> responseObjectClass) throws HorntellException, IOException {

        int code = response.getStatusLine().getStatusCode();

        if(200 < code || code > 300)
        {
           handleApiExceptions(code, response); return null;
        }
        else
            return castResponseToObject(response.getEntity().getContent(), responseObjectClass);

    }


    /**
     * Private Method : To return Response Object to the Calling Method
     */

    private ResponseObject castResponseToObject(InputStream is, Class<ResponseObject> responseObjectClass){
        String raw = null;
        try {
            raw = IOUtils.toString(is);
            log.debug("raw content from response:\n" +raw);
            String raw_data = new JsonParser().parse(raw).getAsJsonObject().get("data").toString();
            ResponseObject responseObject =  new Gson().fromJson( raw_data, responseObjectClass);
            return responseObject;

        } catch(final Throwable t) {
            String msg = "Error handling Mandrill response " +
                    ((raw != null)?": '"+raw+"'" : "");
            log.debug(msg);
            return null;
        }
    }

    private static void handleApiExceptions(int code, HttpResponse response) throws InvalidRequestException, AuthenticationException, HorntellException, IOException {
        Gson gson = new Gson();
        String body = IOUtils.toString(response.getEntity().getContent());
        Map<String,Map<String,Object>> responseMap = gson.fromJson(body, Map.class);

        String message = (String) responseMap.get("error").get("message");
        Integer errorCode = ((Double)responseMap.get("error").get("code")).intValue();
        String type = (String) responseMap.get("error").get("type");

        switch(code)
        {
            case 400:
                throw new InvalidRequestException(message, errorCode, type);
            case 401:
                throw new AuthenticationException(message, errorCode, type);
            case 403:
                throw new ForbiddenException(message, errorCode, type);
            case 404:
                throw new NotFoundException(message, errorCode, type);
            case 500:
                throw new ServiceException(message, errorCode, type);
                // for backwards compatibility, we will handle other
                // HTTP status codes too (to keep the SDK working,
                // even when we send more variants of HTTP status codes
                // through API)
            default:
                 handleUnknownException(message, errorCode, type);
        }

    }

    private static void handleUnknownException(String message,Integer errorCode,String type) throws HorntellException
    {
        switch(errorCode / 100)
        {
            // client error (4xx)
            case 4:
                throw new InvalidRequestException(message, errorCode, type);
                // server error (5xx)
            case 5:
                throw new ServiceException(message, errorCode, type);

                // very generic error (if all else fails)
            default:
                throw new HorntellException(message, errorCode, type);
        }

    }

}
