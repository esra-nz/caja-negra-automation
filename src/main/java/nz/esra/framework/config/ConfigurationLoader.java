package nz.esra.framework.config;

import java.io.IOException;

public class ConfigurationLoader {
    private static ConfigurationLoader instance;
    private static YamlConfiguration config;

    private ConfigurationLoader(){}

    public YamlConfiguration getConfig(){return config;}

    public static ConfigurationLoader getInstance(){
        if(instance == null){
            instance = new ConfigurationLoader();
        }
        config =  new YamlConfiguration();
        try{
            //TODO: Need to figure out how to inject this path into the run
            config.loadResources("C:\\myprojects\\AutomationFramework\\caja-negra-automation\\src\\main\\resources\\framework.yml");
        }catch (IOException e){
            e.printStackTrace();
        }

        return instance;
    }

}
