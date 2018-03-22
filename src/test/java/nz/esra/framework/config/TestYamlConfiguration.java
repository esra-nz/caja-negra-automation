package nz.esra.framework.config;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestYamlConfiguration {

    YamlConfiguration configuration;

    @BeforeClass
    public void setup(){
        configuration = new YamlConfiguration();
        try{
            configuration.loadResources("C:\\myprojects\\FederatedLogins\\idpswitching-automation\\mbie-automation-idpselection\\src\\main\\resources\\framework.yml");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectedBrowser(){
        Assert.assertEquals("chrome-0",configuration.getConfig().getSelectedBrowser());
    }


}
