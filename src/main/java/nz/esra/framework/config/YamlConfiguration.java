package nz.esra.framework.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class YamlConfiguration {

    public FrameworkConfig getConfig() {
        return config;
    }

    private FrameworkConfig config;

    public YamlConfiguration(){}

    //fixme - should be package-private
    public void loadResources(String path) throws IOException {
        Constructor constructor = new Constructor(FrameworkConfig.class);
        Yaml yaml = new Yaml( constructor );

        InputStream input = null;
        try {
            input = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        config = yaml.loadAs( input, FrameworkConfig.class );
    }


    public static void main(String arg[]){
        YamlConfiguration configuration = new YamlConfiguration();
        try{
            configuration.loadResources("C:\\myprojects\\FederatedLogins\\idpswitching-automation\\mbie-automation-idpselection\\src\\main\\resources\\framework.yml");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
