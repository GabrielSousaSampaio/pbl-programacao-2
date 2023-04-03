package model;

import java.util.ArrayList;
import java.util.List;

public class Installation extends Service{

    //Attributes

    private List<String> programs;
    private String operatingSystem;

    public Installation (String operatingSystem){
        this.programs = new ArrayList<String>();
        this.operatingSystem = operatingSystem;
    }

    //Getters and Setters

    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}

