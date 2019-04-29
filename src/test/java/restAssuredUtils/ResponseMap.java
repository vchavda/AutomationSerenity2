package restAssuredUtils;

import config.Appconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component
public class ResponseMap {

    private int statusCode;
    private String responseBody;


    public int getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public String getResponseBody()
    {
        return responseBody;
    }



    public void  setResponseBody(String responseBody) {

        this.responseBody = responseBody;
    }

}
