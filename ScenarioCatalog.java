package model;

// "Lower is better" metric: smaller raw value means bigger score.
public class MinimizingMetric extends Metric {

    public MinimizingMetric(String name, int coefficient, double minValue,
                            double maxValue, String unit, double value) {
        super(name, coefficient, minValue, maxValue, unit, value);
    }

    public double getScore() {
        // formula from the assignment
        double score = 5 - (value - minValue) / (maxValue - minValue) * 4;
        score = ScoreUtils.clamp(score, 1.0, 5.0);
        return ScoreUtils.roundToHalf(score);
    }

    public String getDirectionLabel() {
        return "Lower is better";
    }
}
