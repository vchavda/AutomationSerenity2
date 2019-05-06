package restAssuredUtils;

import org.springframework.stereotype.Component;

@Component
public class ResponseMap {

    private int statusCode;
    private String responseBody;
    private String BaseURL;

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

    public String getBaseURL() {
        return BaseURL;
    }

    public void setBaseURL(String baseURL) {
        BaseURL = baseURL;
    }
}
