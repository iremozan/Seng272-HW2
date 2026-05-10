package model;

// Helper methods for score calculation, used by both metric subclasses.
public class ScoreUtils {

    // Keeps a value between min and max.
    public static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    // Rounds a number to the nearest 0.5 (e.g. 3.24 -> 3.0, 3.26 -> 3.5).
    public static double roundToHalf(double value) {
        return Math.round(value * 2) / 2.0;
    }
}
