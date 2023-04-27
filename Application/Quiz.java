package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Quiz extends JFrame implements ActionListener{

    String questions[][]=new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,Lifeline,submit;
    ButtonGroup groupoptions;

    public static int timer =15;
    public static int ans_given =0;
    public static int count=0;
    public static int score =0;

    String name;

    public Quiz(String name){
        count=0;score=0;
        this.name= name;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,391);
        add(image);

        qno = new JLabel();
        qno.setBounds(100,450,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);

        question = new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);

        questions[0][0] = "In which year NIT J was Established";
        questions[0][1] = "1992";
        questions[0][2] = "1987";
        questions[0][3] = "2007";
        questions[0][4] = "2002";

        questions[1][0] = "In which year NIT Jalandhar was recognised as an Institute of Natonal Importance";
        questions[1][1] = "2006";
        questions[1][2] = "2002";
        questions[1][3] = "2007";
        questions[1][4] = "2002";

        questions[2][0] = "NIT J campus,spreads over an area of how many acres ";
        questions[2][1] = "154";
        questions[2][2] = "157";
        questions[2][3] = "163";
        questions[2][4] = "159";

        questions[3][0] = "How many departments,are there which comes under B.Tech Programmes";
        questions[3][1] = "13";
        questions[3][2] = "9";
        questions[3][3] = "11";
        questions[3][4] = "10";

        questions[4][0] = "What is the name of Current Director of NIT J";
        questions[4][1] = "Dr Binod Kumar Kanaujia";
        questions[4][2] = "Dr Ramana Reddy";
        questions[4][3] = "Dr Rangan Banerjee";
        questions[4][4] = "Dr Rashmi Mittal";

        questions[5][0] = "Who created and lead the older version of NIT J Website";
        questions[5][1] = "Kriti Soni";
        questions[5][2] = "Vipin Kumar";
        questions[5][3] = "Bhupinderjit Singh";
        questions[5][4] = "Anjali Sharma";

        questions[6][0] = "What is the name of the cultural fest of NIT Jalandhar ";
        questions[6][1] = "Mood Swing";
        questions[6][2] = "Exodia";
        questions[6][3] = "Rendezvous";
        questions[6][4] = "Utkansh";

        questions[7][0] = "What is the name of the Technical fest of NIT Jalandhar ";
        questions[7][1] = "Techfest";
        questions[7][2] = "Hackfest";
        questions[7][3] = "Techniti";
        questions[7][4] = "Tryst";

        questions[8][0] = " Which event is organised on the foundation day of NIT J Bharat Dhawni";
        questions[8][1] = "Alcheringa ";
        questions[8][2] = "Nishan Diwas";
        questions[8][3] = "Vijay Jeet";
        questions[8][4] = "Bharat Dhawni";

        questions[9][0] = "Current NIRF ranking of NIT J ";
        questions[9][1] = "52";
        questions[9][2] = "49";
        questions[9][3] = "53";
        questions[9][4] = "51";
        
        answers[0][1] = "1987";
        answers[1][1] = "2002";
        answers[2][1] = "154";
        answers[3][1] = "11";
        answers[4][1] = "Dr Binod Kumar Kanaujia";
        answers[5][1] = "Bhupinderjit Singh";
        answers[6][1] = "Utkansh";
        answers[7][1] = "Techniti";
        answers[8][1] = "Bharat Dhawni";
        answers[9][1] = "52";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170,520,700,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170,560,700,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170,600,700,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170,640,700,30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground((Color.WHITE));
        next.addActionListener(this);
        add(next);

        Lifeline = new JButton("50 50 Lifeline");
        Lifeline.setBounds(1100,630,200,40);
        Lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        Lifeline.setBackground(new Color(30,144,255));
        Lifeline.setForeground((Color.WHITE));
        Lifeline.addActionListener(this);
        add(Lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100,710,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground((Color.WHITE));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        start(count);

        setVisible(true);
        

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if(groupoptions.getSelection () == null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if(count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count); //coz next ki click pr next question dikhana hai
        }else if( ae.getSource() == Lifeline){
            if(count ==2 || count == 4 || count ==6 || count ==8 || count==9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else{
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            Lifeline.setEnabled(false);
        }else if(ae.getSource() == submit){
            ans_given = 1;
            if(groupoptions.getSelection () == null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for(int i=0; i< useranswers.length;i++){
                if (useranswers[i][0].equals(answers[i][1])){
                    score +=10;
                } 
            }
                setVisible(false);
                new Score(name,score);
        
    }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left - "+ timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        if(timer>0){
            g.drawString(time, 1100, 500);
        }else{
            g.drawString("Times up!!!", 1100, 500);
        }

        timer--; //14

        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given=0;
            timer =15;
        } else if(timer <0){
            timer=15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if(count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(groupoptions.getSelection () == null){
                    useranswers[count][0]="";
                }else{
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for(int i=0; i< useranswers.length;i++){
                    if (useranswers[i][0].equals(answers[i][1])){
                        score +=10;
                    } else{
                        score+=0;
                    }
                }
                setVisible(false);
                new Score(name,score);
            } else {
            if(groupoptions.getSelection () == null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++; //0 //1
            start(count);
        }
    }
    }

    public void start(int count){
        qno.setText("" +(count+1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }
    public static void main(String[] args) {
        new Quiz("User");
    }
}