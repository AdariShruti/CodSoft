import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private int timeLeft;
    private int score;

    public QuizApp() {
        // Initialize the quiz
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        questionLabel = new JLabel("What is the capital of France?");
        option1 = new JRadioButton("Paris");
        option2 = new JRadioButton("London");
        option3 = new JRadioButton("Berlin");
        option4 = new JRadioButton("Madrid");
        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);
        submitButton = new JButton("Submit");
        timerLabel = new JLabel("Time Left: 10");

        // Set up the layout
        frame.getContentPane().setLayout(new GridLayout(6, 1));
        frame.getContentPane().add(questionLabel);
        frame.getContentPane().add(option1);
        frame.getContentPane().add(option2);
        frame.getContentPane().add(option3);
        frame.getContentPane().add(option4);
        frame.getContentPane().add(submitButton);
        frame.getContentPane().add(timerLabel);

        // Set up the timer
        timeLeft = 10;
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time Left: " + timeLeft);
                if (timeLeft <= 0) {
                    JOptionPane.showMessageDialog(frame, "Time's up! The correct answer was Paris.");
                    frame.dispose();
                }
            }
        }).start();

        // Set up the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected() && option1.getText().equals("Paris")) {
                    score++;
                }
                JOptionPane.showMessageDialog(frame, "Your score is: " + score);
                frame.dispose();
            }
        });

        // Show the quiz
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}

    
