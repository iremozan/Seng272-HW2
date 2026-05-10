package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.WizardManager;

// Step 1 - Profile screen with three text fields.
public class ProfilePanel extends JPanel implements StepView {

    private WizardManager manager;

    private JTextField usernameField;
    private JTextField schoolField;
    private JTextField sessionField;

    public ProfilePanel(WizardManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 30, 20, 30));

        // --- title ---
        JLabel title = new JLabel("Step 1 - Profile");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));

        JLabel subtitle = new JLabel("Enter your information to start a new measurement session.");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(subtitle, BorderLayout.CENTER);
        topPanel.setBorder(new EmptyBorder(0, 0, 16, 0));

        // --- form ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("User Information"));

        usernameField = new JTextField(20);
        schoolField = new JTextField(20);
        sessionField = new JTextField(20);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("School:"), gbc);
        gbc.gridx = 1;
        formPanel.add(schoolField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Session Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(sessionField, gbc);

        // --- next button ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            // copy text fields to session, then ask the manager to advance
            manager.getSession().setUsername(usernameField.getText());
            manager.getSession().setSchool(schoolField.getText());
            manager.getSession().setSessionName(sessionField.getText());
            manager.goNext();
        });
        buttonPanel.add(nextButton);

        add(topPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void onEnter() {
        // restore text from session if user came back from a later step
        usernameField.setText(manager.getSession().getUsername());
        schoolField.setText(manager.getSession().getSchool());
        sessionField.setText(manager.getSession().getSessionName());
    }
}
