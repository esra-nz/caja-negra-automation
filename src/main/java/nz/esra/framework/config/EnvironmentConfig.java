package nz.esra.framework.config;

import java.util.Map;

public class EnvironmentConfig {
    public String getOauthUrl() {
        return oauthUrl;
    }
    public void setOauthUrl(String oauthUrl) {
        this.oauthUrl = oauthUrl;
    }
    public String getBaseUrl() {
        return baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getCallback() {
        return callback;
    }
    public void setCallback(String callback) {
        this.callback = callback;
    }
    public void setProduction(Map<String,String> production){this.production=production;}
    public Map<String,String> getProduction(){return this.production;}
    public void setSandbox(Map<String,String> sandbox){this.sandbox=sandbox;}
    public Map<String,String> getSandbox(){return this.sandbox;}


    private String baseUrl;
    private String clientId;
    private String oauthUrl;
    private String callback;
    private Map<String,String> production;
    private Map<String,String> sandbox;

}
