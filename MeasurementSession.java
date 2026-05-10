package model;

import java.util.ArrayList;
import java.util.HashMap;

// All scenario data is hard-coded here. Two modes, two scenarios per mode.
// Scenario C uses the exact dataset from the assignment PDF.
public class ScenarioCatalog {

    private HashMap<Mode, ArrayList<Scenario>> scenariosByMode;

    public ScenarioCatalog() {
        scenariosByMode = new HashMap<>();
        scenariosByMode.put(Mode.HEALTH, new ArrayList<>());
        scenariosByMode.put(Mode.EDUCATION, new ArrayList<>());

        loadHealthScenarios();
        loadEducationScenarios();
    }

    public ArrayList<Scenario> listFor(Mode mode) {
        return scenariosByMode.get(mode);
    }

    // ---------------- HEALTH ----------------

    private void loadHealthScenarios() {
        // Scenario A - Hospital System
        Scenario hospital = new Scenario("Scenario A - Hospital System", Mode.HEALTH);

        Dimension usability = new Dimension("Usability", 20);
        usability.addMetric(new MaximizingMetric("SUS score", 50, 0, 100, "points", 78));
        usability.addMetric(new MinimizingMetric("Task completion time", 50, 0, 120, "sec", 35));
        hospital.addDimension(usability);

        Dimension perf = new Dimension("Performance Efficiency", 20);
        perf.addMetric(new MinimizingMetric("Page load time", 50, 0, 10, "sec", 2));
        perf.addMetric(new MaximizingMetric("Concurrent users", 50, 0, 1000, "users", 720));
        hospital.addDimension(perf);

        Dimension reliability = new Dimension("Reliability", 25);
        reliability.addMetric(new MaximizingMetric("Uptime", 50, 95, 100, "%", 99.9));
        reliability.addMetric(new MinimizingMetric("MTTR", 50, 0, 60, "min", 12));
        hospital.addDimension(reliability);

        Dimension security = new Dimension("Security", 25);
        security.addMetric(new MinimizingMetric("Vulnerability count", 50, 0, 50, "issues", 3));
        security.addMetric(new MaximizingMetric("Auth strength", 50, 0, 100, "score", 90));
        hospital.addDimension(security);

        Dimension funcSuit = new Dimension("Functional Suitability", 10);
        funcSuit.addMetric(new MaximizingMetric("Feature completion", 50, 0, 100, "%", 92));
        funcSuit.addMetric(new MinimizingMetric("Critical bug count", 50, 0, 20, "bugs", 1));
        hospital.addDimension(funcSuit);

        scenariosByMode.get(Mode.HEALTH).add(hospital);

        // Scenario B - Patient Portal
        Scenario portal = new Scenario("Scenario B - Patient Portal", Mode.HEALTH);

        Dimension u2 = new Dimension("Usability", 25);
        u2.addMetric(new MaximizingMetric("SUS score", 50, 0, 100, "points", 70));
        u2.addMetric(new MinimizingMetric("Task completion time", 50, 0, 120, "sec", 50));
        portal.addDimension(u2);

        Dimension p2 = new Dimension("Performance Efficiency", 20);
        p2.addMetric(new MinimizingMetric("Page load time", 50, 0, 10, "sec", 4));
        p2.addMetric(new MaximizingMetric("Concurrent users", 50, 0, 1000, "users", 450));
        portal.addDimension(p2);

        Dimension r2 = new Dimension("Reliability", 20);
        r2.addMetric(new MaximizingMetric("Uptime", 50, 95, 100, "%", 99.2));
        r2.addMetric(new MinimizingMetric("MTTR", 50, 0, 60, "min", 25));
        portal.addDimension(r2);

        Dimension s2 = new Dimension("Security", 25);
        s2.addMetric(new MinimizingMetric("Vulnerability count", 50, 0, 50, "issues", 8));
        s2.addMetric(new MaximizingMetric("Auth strength", 50, 0, 100, "score", 75));
        portal.addDimension(s2);

        Dimension f2 = new Dimension("Functional Suitability", 10);
        f2.addMetric(new MaximizingMetric("Feature completion", 50, 0, 100, "%", 80));
        f2.addMetric(new MinimizingMetric("Critical bug count", 50, 0, 20, "bugs", 4));
        portal.addDimension(f2);

        scenariosByMode.get(Mode.HEALTH).add(portal);
    }

    // ---------------- EDUCATION ----------------

    private void loadEducationScenarios() {
        // Scenario C - Team Alpha (matches the PDF example dataset)
        Scenario alpha = new Scenario("Scenario C - Team Alpha", Mode.EDUCATION);

        Dimension usability = new Dimension("Usability", 25);
        usability.addMetric(new MaximizingMetric("SUS score", 50, 0, 100, "points", 89));
        usability.addMetric(new MinimizingMetric("Onboarding time", 50, 0, 60, "min", 5));
        alpha.addDimension(usability);

        Dimension perf = new Dimension("Performance Efficiency", 20);
        perf.addMetric(new MinimizingMetric("Video start time", 50, 0, 15, "sec", 2));
        perf.addMetric(new MaximizingMetric("Concurrent exams", 50, 0, 600, "users", 480));
        alpha.addDimension(perf);

        Dimension access = new Dimension("Accessibility", 20);
        access.addMetric(new MaximizingMetric("WCAG compliance", 50, 0, 100, "%", 92));
        access.addMetric(new MaximizingMetric("Screen reader score", 50, 0, 100, "%", 88));
        alpha.addDimension(access);

        Dimension reliability = new Dimension("Reliability", 20);
        reliability.addMetric(new MaximizingMetric("Uptime", 50, 95, 100, "%", 99.7));
        reliability.addMetric(new MinimizingMetric("MTTR", 50, 0, 120, "min", 25));
        alpha.addDimension(reliability);

        Dimension funcSuit = new Dimension("Functional Suitability", 15);
        funcSuit.addMetric(new MaximizingMetric("Feature completion", 50, 0, 100, "%", 95));
        funcSuit.addMetric(new MaximizingMetric("Assignment submit rate", 50, 0, 100, "%", 87));
        alpha.addDimension(funcSuit);

        scenariosByMode.get(Mode.EDUCATION).add(alpha);

        // Scenario D - Team Beta (lower numbers, useful for gap analysis demo)
        Scenario beta = new Scenario("Scenario D - Team Beta", Mode.EDUCATION);

        Dimension u2 = new Dimension("Usability", 25);
        u2.addMetric(new MaximizingMetric("SUS score", 50, 0, 100, "points", 62));
        u2.addMetric(new MinimizingMetric("Onboarding time", 50, 0, 60, "min", 25));
        beta.addDimension(u2);

        Dimension p2 = new Dimension("Performance Efficiency", 20);
        p2.addMetric(new MinimizingMetric("Video start time", 50, 0, 15, "sec", 7));
        p2.addMetric(new MaximizingMetric("Concurrent exams", 50, 0, 600, "users", 280));
        beta.addDimension(p2);

        Dimension a2 = new Dimension("Accessibility", 20);
        a2.addMetric(new MaximizingMetric("WCAG compliance", 50, 0, 100, "%", 70));
        a2.addMetric(new MaximizingMetric("Screen reader score", 50, 0, 100, "%", 65));
        beta.addDimension(a2);

        Dimension r2 = new Dimension("Reliability", 20);
        r2.addMetric(new MaximizingMetric("Uptime", 50, 95, 100, "%", 98.5));
        r2.addMetric(new MinimizingMetric("MTTR", 50, 0, 120, "min", 60));
        beta.addDimension(r2);

        Dimension f2 = new Dimension("Functional Suitability", 15);
        f2.addMetric(new MaximizingMetric("Feature completion", 50, 0, 100, "%", 75));
        f2.addMetric(new MaximizingMetric("Assignment submit rate", 50, 0, 100, "%", 70));
        beta.addDimension(f2);

        scenariosByMode.get(Mode.EDUCATION).add(beta);
    }
}
