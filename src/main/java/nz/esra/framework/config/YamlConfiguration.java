package nz.esra.framework.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class YamlConfiguration {

    public FrameworkConfig getFrameworkConfig() {
        return frameworkConfig;
    }
    public BrowserConfig getBrowserConfig() {
        return browserConfig;
    }
    public EnvironmentConfig getEnvironmentConfig() {
        return environmentConfig;
    }

    private FrameworkConfig frameworkConfig;
    private BrowserConfig browserConfig;
    private EnvironmentConfig environmentConfig;

    public YamlConfiguration(){}

    public void loadResources(String path) throws IOException {
        Constructor constructor = new Constructor(FrameworkConfig.class);
        Yaml yaml = new Yaml( constructor );

        InputStream input = null;
        try {
            input = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        frameworkConfig = yaml.loadAs( input, FrameworkConfig.class );
        browserConfig = frameworkConfig.getSelectedBrowserConfig();
        environmentConfig = frameworkConfig.getSelectedEnvionmentConfig();
    }


    public static void main(String arg[]){
        YamlConfiguration configuration = new YamlConfiguration();
        try{
            configuration.loadResources("C:\\myprojects\\AutomationFramework\\caja-negra-automation\\src\\main\\resources\\framework.yml");
            System.out.println(configuration.getBrowserConfig().getName());
            System.out.println(configuration.getEnvironmentConfig().getBaseUrl());
            System.out.println(configuration.getEnvironmentConfig().getProduction().get("clientId"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
