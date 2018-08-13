package build.dream.common.beans;

import java.util.Date;

public class ComponentAccessToken {
    private String componentAccessToken;
    private Integer expiresIn;
    private Date fetchTime;

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }
}
