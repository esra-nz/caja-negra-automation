package nz.esra.framework.config;

public class BrowserConfig {

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public Boolean getFullscreen() {
        return fullscreen;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setFullscreen(Boolean fullscreen) {
        this.fullscreen = fullscreen;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    private String name;
    private String type;
    private Boolean fullscreen;
    private int height;
    private int width;
}
