package view;

// Implemented by every step panel. onEnter() is called by the wizard
// just before the panel is shown, so the panel can refresh itself.
public interface StepView {
    void onEnter();
}
