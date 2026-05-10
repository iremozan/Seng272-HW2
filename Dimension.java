package model;

// Holds everything the user enters during a wizard run.
public class MeasurementSession {

    private String username = "";
    private String school = "";
    private String sessionName = "";

    private QualityType qualityType;
    private Mode mode;
    private Scenario scenario;

    public String getUsername() { return username; }
    public void   setUsername(String username) { this.username = username; }

    public String getSchool() { return school; }
    public void   setSchool(String school) { this.school = school; }

    public String getSessionName() { return sessionName; }
    public void   setSessionName(String sessionName) { this.sessionName = sessionName; }

    public QualityType getQualityType() { return qualityType; }
    public void        setQualityType(QualityType qualityType) { this.qualityType = qualityType; }

    public Mode getMode() { return mode; }
    public void setMode(Mode mode) { this.mode = mode; }

    public Scenario getScenario() { return scenario; }
    public void     setScenario(Scenario scenario) { this.scenario = scenario; }

    // Step 1 is filled in if all three text fields have content.
    public boolean isProfileFilled() {
        return !username.trim().isEmpty()
            && !school.trim().isEmpty()
            && !sessionName.trim().isEmpty();
    }

    // Step 2 is filled in if all three selections were made.
    public boolean isScopeChosen() {
        return qualityType != null && mode != null && scenario != null;
    }
}
