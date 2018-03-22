package nz.esra.framework.config;

import java.util.Map;

public class FrameworkConfig {

    private String selectedBrowser;
    private Map<String, BrowserConfig> browsers;

    public Map<String, BrowserConfig> getBrowsers() {
        return browsers;
    }

    public void setBrowsers(Map<String, BrowserConfig> browsers) {
        this.browsers = browsers;
    }

    public void setSelectedBrowser(String selectedBrowser){
        this.selectedBrowser=selectedBrowser;
    }
    public String getSelectedBrowser(){
        return this.selectedBrowser;
    }



}
