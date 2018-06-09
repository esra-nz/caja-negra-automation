package nz.esra.framework.pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class AbstractPage {
    private HashMap<String, By> pageObjects = new LinkedHashMap<>();
    protected PageHandler handler;

    public abstract void setPageHandler(PageHandler handler);


    protected void clearPageObjects(){
        pageObjects.clear();
    }

    private void addPageObject(String key, By element){
        pageObjects.put(key,element);
    }

    protected void addPageObjectById(String key){
        addPageObject(key,By.id(key));
    }


    public By getPageObjectById(String key) { return pageObjects.get(key); }

    protected void clickElement(String key){
        if(!pageObjects.containsKey(key)){
            //TODO: Handle exception if pageObjects does not have the key
        }
        handler.click(pageObjects.get(key));
    }

}
