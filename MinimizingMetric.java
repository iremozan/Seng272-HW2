package model;

// "Higher is better" metric: bigger raw value means bigger score.
public class MaximizingMetric extends Metric {

    public MaximizingMetric(String name, int coefficient, double minValue,
                            double maxValue, String unit, double value) {
        super(name, coefficient, minValue, maxValue, unit, value);
    }

    public double getScore() {
        // formula from the assignment
        double score = 1 + (value - minValue) / (maxValue - minValue) * 4;
        score = ScoreUtils.clamp(score, 1.0, 5.0);
        return ScoreUtils.roundToHalf(score);
    }

    public String getDirectionLabel() {
        return "Higher is better";
    }
}
