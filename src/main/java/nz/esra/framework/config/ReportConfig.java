package nz.esra.framework.config;

public class ReportConfig {

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getOutputPath() {return outputPath;}
    public void setOutputPath(String outputPath) {this.outputPath = outputPath;}
    public boolean isCaptureScreenShot() {return captureScreenShot;}
    public void setCaptureScreenShot(boolean captureScreenShot) {this.captureScreenShot = captureScreenShot;}

    private String name;
    private String outputPath;
    private boolean captureScreenShot;
}
