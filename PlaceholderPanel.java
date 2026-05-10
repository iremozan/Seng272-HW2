package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Main application window. Step header on top, step panels in the middle
// (switched by CardLayout).
public class AppFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private StepHeader header;

    public AppFrame() {
        setTitle("ISO 15939 Measurement Process Simulator");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        String[] stepNames = { "Profile", "Define", "Plan", "Collect", "Analyse" };
        header = new StepHeader(stepNames);

        setLayout(new BorderLayout());
        add(header, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }

    public void addStepCard(JPanel panel, int index) {
        cardPanel.add(panel, "step" + index);
    }

    public void showStep(int index) {
        cardLayout.show(cardPanel, "step" + index);
    }

    public StepHeader getHeader() {
        return header;
    }
}
