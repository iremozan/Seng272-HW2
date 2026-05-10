package model;

// Available modes. Custom is a bonus and not implemented in V1.
public enum Mode {
    HEALTH("Health"),
    EDUCATION("Education");

    private String label;

    Mode(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}
