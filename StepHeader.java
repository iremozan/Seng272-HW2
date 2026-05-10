package model;

import java.util.ArrayList;

// A quality dimension (like "Usability" or "Reliability") that holds a
// list of metrics and has its own coefficient inside the scenario.
public class Dimension {

    private String name;
    private int coefficient;
    private ArrayList<Metric> metrics;

    public Dimension(String name, int coefficient) {
        this.name = name;
        this.coefficient = coefficient;
        this.metrics = new ArrayList<>();
    }

    public void addMetric(Metric m) {
        metrics.add(m);
    }

    public String            getName()        { return name; }
    public int               getCoefficient() { return coefficient; }
    public ArrayList<Metric> getMetrics()     { return metrics; }

    // Weighted average of all metric scores in this dimension.
    public double getWeightedScore() {
        double sum = 0;
        int totalCoef = 0;
        for (Metric m : metrics) {
            sum += m.getScore() * m.getCoefficient();
            totalCoef += m.getCoefficient();
        }
        if (totalCoef == 0) return 0;
        return sum / totalCoef;
    }
}
