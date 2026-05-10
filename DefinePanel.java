package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// The step indicator shown at the top of the window. Active step is blue,
// completed steps are green with a check mark, pending steps are gray.
public class StepHeader extends JPanel {

    private String[] stepNames;
    private JLabel[] labels;

    public StepHeader(String[] stepNames) {
        this.stepNames = stepNames;
        this.labels = new JLabel[stepNames.length];

        setLayout(new GridLayout(1, stepNames.length, 4, 0));
        setBorder(new EmptyBorder(12, 12, 12, 12));
        setBackground(new Color(245, 246, 250));

        for (int i = 0; i < stepNames.length; i++) {
            labels[i] = new JLabel("", SwingConstants.CENTER);
            labels[i].setOpaque(true);
            labels[i].setBorder(new EmptyBorder(8, 6, 8, 6));
            add(labels[i]);
        }
        update(0);
    }

    // Repaints the header with the given step as active.
    public void update(int activeIndex) {
        for (int i = 0; i < stepNames.length; i++) {
            // Build the text: completed steps get a check mark.
            String text;
            if (i < activeIndex) {
                text = "\u2713 " + stepNames[i];
            } else {
                text = (i + 1) + ". " + stepNames[i];
            }
            labels[i].setText(text);

            // Set colors based on state.
            if (i == activeIndex) {
                labels[i].setBackground(new Color(33, 102, 230));   // blue
                labels[i].setForeground(Color.WHITE);
                labels[i].setFont(labels[i].getFont().deriveFont(Font.BOLD));
            } else if (i < activeIndex) {
                labels[i].setBackground(new Color(76, 175, 80));    // green
                labels[i].setForeground(Color.WHITE);
                labels[i].setFont(labels[i].getFont().deriveFont(Font.PLAIN));
            } else {
                labels[i].setBackground(new Color(220, 222, 230));  // gray
                labels[i].setForeground(new Color(80, 82, 90));
                labels[i].setFont(labels[i].getFont().deriveFont(Font.PLAIN));
            }
        }
    }
}
