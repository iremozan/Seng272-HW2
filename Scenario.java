package model;

// Base class for a metric. The subclasses (MaximizingMetric and
// MinimizingMetric) decide how the raw value is turned into a 1-5 score.
public abstract class Metric {

    // protected so subclasses can access them directly
    protected String name;
    protected int coefficient;
    protected double minValue;
    protected double maxValue;
    protected String unit;
    protected double value;

    public Metric(String name, int coefficient, double minValue,
                  double maxValue, String unit, double value) {
        this.name = name;
        this.coefficient = coefficient;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.value = value;
    }

    public String getName()        { return name; }
    public int    getCoefficient() { return coefficient; }
    public double getMinValue()    { return minValue; }
    public double getMaxValue()    { return maxValue; }
    public String getUnit()        { return unit; }
    public double getValue()       { return value; }

    public void setValue(double value) {
        this.value = value;
    }

    // Range as a string like "0-100" (min and max are always whole numbers
    // in our scenarios so casting to int is fine).
    public String getRangeText() {
        return (int) minValue + "-" + (int) maxValue;
    }

    // Subclasses must provide these.
    public abstract double getScore();
    public abstract String getDirectionLabel();
}
