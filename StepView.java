import javax.swing.SwingUtilities;

import controller.WizardManager;
import view.AppFrame;
import view.DefinePanel;
import view.PlaceholderPanel;
import view.ProfilePanel;

// Application entry point. Creates the wizard manager and the frame,
// builds all five step panels, and starts the wizard.
public class Main {

    public static void main(String[] args) {
        // Swing must be built on the Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> startApp());
    }

    private static void startApp() {
        WizardManager manager = new WizardManager();
        AppFrame frame = new AppFrame();
        manager.setFrame(frame);

        // Build all five step panels.
        ProfilePanel step1 = new ProfilePanel(manager);
        DefinePanel step2 = new DefinePanel(manager);
        PlaceholderPanel step3 = new PlaceholderPanel(manager,
                "Step 3 - Plan Measurement", "Coming in V2", true);
        PlaceholderPanel step4 = new PlaceholderPanel(manager,
                "Step 4 - Collect Data", "Coming in V2", true);
        PlaceholderPanel step5 = new PlaceholderPanel(manager,
                "Step 5 - Analyse", "Coming in V3", false);

        // Register them with both the frame (CardLayout) and the manager
        // (in matching order so step indices line up).
        frame.addStepCard(step1, 0);
        frame.addStepCard(step2, 1);
        frame.addStepCard(step3, 2);
        frame.addStepCard(step4, 3);
        frame.addStepCard(step5, 4);

        manager.addStep(step1);
        manager.addStep(step2);
        manager.addStep(step3);
        manager.addStep(step4);
        manager.addStep(step5);

        manager.start();
        frame.setVisible(true);
    }
}
