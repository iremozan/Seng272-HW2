package model;

// Two quality types defined by the assignment.
public enum QualityType {
    PRODUCT("Product Quality"),
    PROCESS("Process Quality");

    private String label;

    QualityType(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}
