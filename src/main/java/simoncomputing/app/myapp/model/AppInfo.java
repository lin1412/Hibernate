package simoncomputing.app.myapp.model;

public class AppInfo {
    private String module;
    private String version;
    
    public String getModule() {
            return module;
    }
    
    public void setModule(String module) {
            this.module = module;
    }
    
    public String getVersion() {
            return version;
    }
    
    public void setVersion(String version) {
            this.version = version;
    }
    
    public String getWarFn() {
            return module + version + ".war";
    }
    
}
