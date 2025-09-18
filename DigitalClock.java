import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;  
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // Frame settings
        setTitle("Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center of screen
        setLayout(new BorderLayout());

        // Time format
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Label to show time
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        add(timeLabel, BorderLayout.CENTER);

        // Timer: update every 1000 ms (1 sec)
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateClock();
            }
        });
        timer.start(); // Start timer

        // Initialize with current time
        updateClock();

        setVisible(true);
    }

    private void updateClock() {
        Date now = new Date();
        String timeStr = timeFormat.format(now);
        timeLabel.setText(timeStr);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DigitalClock());
    }
}
