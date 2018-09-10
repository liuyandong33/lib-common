package build.dream.common.beans;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebResponse {
    private String result;
    private Map<String, List<String>> headers = new HashMap<String, List<String>>();
    private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
    private int responseCode;

    public WebResponse() {

    }

    public WebResponse(String result, Map<String, List<String>> headers, int responseCode) {
        this.result = result;
        this.responseCode = responseCode;
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            String key = header.getKey();
            List<String> headerValues = header.getValue();
            if ("Set-Cookie".equalsIgnoreCase(key)) {
                this.headers.put(key, headerValues);
                for (String headerValue : headerValues) {
                    String[] array = headerValue.split("; ");
                    String[] nameAndValue = array[0].split("=");
                    String name = nameAndValue[0];
                    String value = nameAndValue[1];

                    Cookie cookie = new Cookie(name, value);

                    int length = array.length;
                    for (int index = 1; index < length; index++) {
                        String item = array[index];
                        if (item.indexOf("=") >= 0) {
                            String[] attributeNameAndValue = item.split("=");
                            String attributeName = attributeNameAndValue[0];
                            String attributeValue = attributeNameAndValue[1];
                            if ("Comment".equalsIgnoreCase(attributeName)) {
                                cookie.setComment(attributeValue);
                            } else if ("Domain".equalsIgnoreCase(attributeName)) {
                                cookie.setDomain(attributeValue);
                            } else if ("Max-Age".equalsIgnoreCase(attributeName)) {
                                cookie.setMaxAge(Integer.parseInt(attributeValue));
                            } else if ("Path".equalsIgnoreCase(attributeName)) {
                                cookie.setPath(attributeValue);
                            }
                        } else if ("Secure".equalsIgnoreCase(item)) {
                            cookie.setSecure(true);
                        } else if ("HttpOnly".equalsIgnoreCase(item)) {
                            cookie.setHttpOnly(true);
                        }
                    }
                    cookieMap.put(name, cookie);
                }
            } else {
                this.headers.put(key, headerValues);
            }
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
