package model;

import java.util.List;

public class Installation extends Service{

    //Attributes

    private List<String> programs;
    private String OperatingSystem;

    //Getters and Setters


    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(String OperatingSystem) {
        this.OperatingSystem = OperatingSystem;
    }

}

