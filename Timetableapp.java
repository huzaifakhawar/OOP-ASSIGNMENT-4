package timetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timetableapp {
    private JFrame frame;
    private JPanel panel;

    private JTextField teacherNameField;
    private JTextField roomNumberField;
    private JTextField sectionField;
    private JButton addTeacherButton;
    private JButton addRoomButton;
    private JButton addSectionButton;
    private JTextArea timetableArea;
    private JButton scheduleButton;

    public Timetableapp() {
        frame = new JFrame("Bahria University Timetabling System");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        teacherNameField = new JTextField(20);
        addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.addActionListener(new AddTeacherButtonListener());

        roomNumberField = new JTextField(20);
        addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new AddRoomButtonListener());

        sectionField = new JTextField(20);
        addSectionButton = new JButton("Add Section");
        addSectionButton.addActionListener(new AddSectionButtonListener());

        timetableArea = new JTextArea(10, 30);
        scheduleButton = new JButton("Show Timetable");
        scheduleButton.addActionListener(new ScheduleButtonListener());

        panel.add(new JLabel("Teacher Name:"));
        panel.add(teacherNameField);
        panel.add(addTeacherButton);
        panel.add(new JLabel("Room Number:"));
        panel.add(roomNumberField);
        panel.add(addRoomButton);
        panel.add(new JLabel("Section:"));
        panel.add(sectionField);
        panel.add(addSectionButton);
        panel.add(scheduleButton);
        panel.add(timetableArea);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class AddTeacherButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = teacherNameField.getText();
            try {
                DataBaseHelper.addTeacher(name);
                JOptionPane.showMessageDialog(frame, "Teacher added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error adding teacher: " + ex.getMessage());
            }
        }
    }

    private class AddRoomButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int number = Integer.parseInt(roomNumberField.getText());
            try {
                DataBaseHelper.addRoom(number, 30); // Assuming a default capacity of 30
                JOptionPane.showMessageDialog(frame, "Room added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error adding room: " + ex.getMessage());
            }
        }
    }

    private class AddSectionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = sectionField.getText();
            try {
                DataBaseHelper.addSection(name);
                JOptionPane.showMessageDialog(frame, "Section added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error adding section: " + ex.getMessage());
            }
        }
    }

    private class ScheduleButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    public static void main(String[] args) {
        new Timetableapp();
    }
}
