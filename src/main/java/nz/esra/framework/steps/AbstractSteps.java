package nz.esra.framework.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nz.esra.framework.config.ConfigurationLoader;
import nz.esra.framework.pages.AbstractPage;
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
        if ("callback".equals(key)) return loader.getConfig().getEnvironmentConfig().getCallback();
        if(key.contains(":")){
            String[] map = key.split(":");
            if("production".equals(map[0])) return loader.getConfig().getEnvironmentConfig().getProduction().get(map[1]);
            if("sandbox".equals(map[0])) return loader.getConfig().getEnvironmentConfig().getSandbox().get(map[1]);
        }
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
    }

    private void assertBoolean(boolean actual,boolean check, boolean capture){
        try{
            assertThat(actual,CoreMatchers.is(check));
        }catch(AssertionError ae){
            if(capture) captureScreenShot();
            throw ae;
        }
    }



    protected void assertContains(String actual,String contains, boolean capture){
        Matcher<String> matcher = CoreMatchers.containsString(contains);
        assertMatcher(actual, matcher,capture);
    }

    protected void assertContainsElements(String contains[], AbstractPage page, boolean capture){
//        System.out.println(page);
//        System.out.println(page.getPageObjectById("icon-1"));
//        System.out.println(handler.containsElement(page.getPageObjectById("icon-1")));

        for(String key : contains){
            assertBoolean(handler.containsElement(page.getPageObjectById(key)),true,capture);
        }
    }

    protected void assertDoesNotContainsElements(String contains[], AbstractPage page, boolean capture){
        for(String key : contains){
            assertBoolean(handler.containsElement(page.getPageObjectById(key)),false,capture);
        }
    }

}
