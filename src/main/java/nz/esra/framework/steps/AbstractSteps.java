package nz.esra.framework.steps;

import nz.esra.framework.config.ConfigurationLoader;
import nz.esra.framework.pages.PageHandler;
import nz.esra.framework.reports.Reporter;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;


public class AbstractSteps {
    protected ConfigurationLoader loader = ConfigurationLoader.getInstance();
    protected PageHandler handler;

    public String getEnvironmentVariable(String envVariable){
        String key =envVariable.substring(envVariable.indexOf(":")+1);  //TODO use env: in index off and thrown exeception if index of not found
        if ("oauthUrl".equals(key)) return loader.getConfig().getEnvironmentConfig().getOauthUrl();
        if ("clientId".equals(key)) return loader.getConfig().getEnvironmentConfig().getClientId();
        if ("callback".equals(key)) return loader.getConfig().getEnvironmentConfig().getCallback();
        return null;
    }

    private void captureScreenShot() {
        if(Reporter.getExtentReport()!=null && loader.getConfig().getFrameworkConfig().getReports().isCaptureScreenShot()){
            try{
                Reporter.addScreenCaptureFromPath(handler.captureScreenShot());
            }catch (IOException ioe){
                Reporter.addStepLog("Could not add screen shot to step");
            }
        }
    }

    private void assertMatcher(String actual,Matcher<String> matcher,boolean capture){
        try{
            assertThat(actual, matcher);
        }catch(AssertionError ae){
            if(capture) captureScreenShot();
            throw ae;
        }
        Reporter.addStepLog("Out some info here");
    }

    protected void assertContains(String actual,String contains, boolean capture){
        Matcher<String> matcher = CoreMatchers.containsString(contains);
        assertMatcher(actual, matcher,capture);
    }

}
