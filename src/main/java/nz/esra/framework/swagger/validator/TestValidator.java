package nz.esra.framework.swagger.validator;


import v2.io.swagger.parser.SwaggerParser;
import v2.io.swagger.parser.util.SwaggerDeserializationResult;

public class TestValidator {

    public  static  void main(String arg[]){
        String location = "C:\\tmp\\definition\\nzbn.yml";
        SwaggerParser parser = new SwaggerParser();
        SwaggerDeserializationResult readResult = parser.readWithInfo(location, null, true);
        System.out.println(readResult.getMessages());
    }




}
