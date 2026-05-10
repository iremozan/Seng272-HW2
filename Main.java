package model;

import java.util.ArrayList;

// A scenario contains a fixed set of dimensions for a particular mode.
public class Scenario {

    private String name;
    private Mode mode;
    private ArrayList<Dimension> dimensions;

    public Scenario(String name, Mode mode) {
        this.name = name;
        this.mode = mode;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(Dimension d) {
        dimensions.add(d);
    }

    public String               getName()       { return name; }
    public Mode                 getMode()       { return mode; }
    public ArrayList<Dimension> getDimensions() { return dimensions; }

    // Used by the gap analysis in step 5.
    public Dimension getWeakestDimension() {
        Dimension weakest = null;
        double lowestScore = 999;
        for (Dimension d : dimensions) {
            if (d.getWeightedScore() < lowestScore) {
                lowestScore = d.getWeightedScore();
                weakest = d;
            }
        }
        return weakest;
    }

    // So JComboBox shows the scenario name without a custom renderer.
    public String toString() {
        return name;
    }
}
