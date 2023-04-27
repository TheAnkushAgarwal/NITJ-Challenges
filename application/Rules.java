package Application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton start, back;
    public Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+ name + " to NITJ CHALLENGES");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
            "<html>"+
            "1.You have only 15 sec to answer a question"+"<br>"+"<br>"+
            "2.You can select only one option per question"+"<br>"+"<br>"+
            "3.If you do not answer a question in 15s you will be automatically taken to next question"+"<br>"+"<br>"+
            "4.You cannot come back to a question once the timer times out."+"<br>"+"<br>"+
            "5.You will be awarded 10 points for each correct answer."+"<br>"+"<br>"+
            "6.There is no negative marking for a wrong answer."+"<br>"+"<br>"+
            "7.ALL THE BEST"+"<br>"+"<br>"+
            "<html>"
        );
        add(rules);

        back= new JButton("Back");
        back.setBounds(250,500,100,30);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start= new JButton("Start");
        start.setBounds(400,500,100,30);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800,650);
        setLocation(550,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==start){
            setVisible(false);
            new Quiz(name);
        } else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
