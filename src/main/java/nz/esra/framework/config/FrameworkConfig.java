package nz.esra.framework.config;

import java.util.Map;

public class FrameworkConfig {

    private String selectedBrowser;
    private String selectedEnvironment;
    private Map<String, BrowserConfig> browsers;
    private Map<String, EnvironmentConfig> environments;
    private ReportConfig reports;

    public ReportConfig getReports() {return reports;}

    public void setReports(ReportConfig reports) {this.reports = reports;}

    public String getSelectedEnvironment() { return selectedEnvironment;}

    public void setSelectedEnvironment(String selectedEnvironment) {this.selectedEnvironment = selectedEnvironment;}

    public Map<String, EnvironmentConfig> getEnvironments() { return environments;}

    public void setEnvironments(Map<String, EnvironmentConfig> environments) {this.environments = environments;}

    public Map<String, BrowserConfig> getBrowsers() {
        return browsers;
    }

    public void setBrowsers(Map<String, BrowserConfig> browsers) {
        this.browsers = browsers;
    }

    public void setSelectedBrowser(String selectedBrowser) {
        this.selectedBrowser = selectedBrowser;
    }

    public String getSelectedBrowser() {
        return this.selectedBrowser;
    }

    public BrowserConfig getSelectedBrowserConfig() {
        return this.browsers.get(this.selectedBrowser);
    }
    public EnvironmentConfig getSelectedEnvionmentConfig() {return this.environments.get(this.selectedEnvironment);}


}