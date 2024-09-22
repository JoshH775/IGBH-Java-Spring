import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.FileNotFoundException;

public class GUI extends JFrame{
    static int input = 0;
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        GUI gui = new GUI();
        Server server = new Server();
        double value = 1000000000000000.0;
        Node currentNode = server.returnNode(1);
        updateTextPane(gui.QuestionDisplay,"Question: "+currentNode.getQuestion());
        updateLabel(gui.currentValue,"Current value: "+value);
        while(true){

            if (currentNode.getNodeID()==40){
                updateLabel(gui.currentValue,"Your total: $"+server.toNormalForm(value));
            }
            if (input==1){
                if (currentNode.getNodeID()==40){
                    System.out.println("Your exoplanet is worth approximately " + server.toNormalForm(value) + " dollars."+" At Earth's current global annual GDP, accounting for fluctuations it would take "+(server.rollingGDPFunc(value)+1)+" years to amass this amount.");
                    System.out.println("As an individual earning the average American yearly salary, it would take you "+server.individualYears(value)+" years to amass this amount (not including living expenses or tax).\n");
                    value=1000000000000000.0;
                    currentNode=server.returnNode(1);
                    updateTextPane(gui.QuestionDisplay,"Question: "+currentNode.getQuestion());
                    updateLabel(gui.currentValue,"Current value: "+value);
                    input=0;
                }
                else{
                    value=value*currentNode.getYesMultiplier();
                    int nextNode=currentNode.getYesID();
                    currentNode=server.returnNode(nextNode);
                    input=0;
                    updateTextPane(gui.QuestionDisplay,"Question: "+currentNode.getQuestion());
                    updateLabel(gui.currentValue,"Current value: "+value);
                }

            }
            if (input==2){
                if(currentNode.getNodeID()==40){
                    System.out.println("Your exoplanet is worth approximately " + server.toNormalForm(value) + " dollars."+" At Earth's current global annual GDP, accounting for fluctuations it would take "+(server.rollingGDPFunc(value)+1)+" years to amass this amount.");
                    System.out.println("As an individual earning the average American yearly salary, it would take you "+server.individualYears(value)+" years to amass this amount (not including living expenses or tax).\n");
                    gui.dispose();
                    break;
                }
                else{
                    value=value*currentNode.getNoMultiplier();
                    int nextNode=currentNode.getNoID();
                    currentNode=server.returnNode(nextNode);
                    input=0;
                    updateTextPane(gui.QuestionDisplay,"Question: "+currentNode.getQuestion());
                    updateLabel(gui.currentValue,"Current value: "+value);
                }

            }
            if (input!= 1 && input!=2){
                Thread.sleep(200);
            }

        }


    }
;

    GUI() throws FileNotFoundException {
        this.setSize(400,600);
        this.setVisible(true);
        this.setTitle("2058436");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(125,50,250));

        startingValue.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,30));
        startingValue.setBounds(5,-100,325,350);

        QuestionDisplay.setText("Question: ");
        QuestionDisplay.setContentType("text/html");
        QuestionDisplay.setOpaque(false);
        QuestionDisplay.setEditable(false);
        QuestionDisplay.setBounds(7,115,325,350);
        QuestionDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

        currentValue.setBounds(5,95,325,350);
        currentValue.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,15));

        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(null);
        topPanel.setBorder(totalBorder);
        topPanel.setBounds(18,10,350,320);

        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(null);
        buttonPanel.setBorder(totalBorder);
        buttonPanel.setBounds(18,340,350,200);

        yesButton.setBounds(10,20,160,160);
        yesButton.addActionListener(e -> input=1);
        yesButton.setText("Yes");
        yesButton.setFocusable(false);

        noButton.setBounds(180,20,160,160);
        noButton.addActionListener(e -> input=2);
        noButton.setText("No");
        noButton.setFocusable(false);


        this.add(topPanel);
        topPanel.add(startingValue);
        topPanel.add(QuestionDisplay);
        topPanel.add(currentValue);


        this.add(buttonPanel);
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
    }

    JLabel currentValue = new JLabel("Test Value",SwingConstants.CENTER);
    JTextPane QuestionDisplay = new JTextPane();
    JLabel startingValue = new JLabel("Starting value: 1.0E15",SwingConstants.CENTER);
    JPanel topPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton yesButton = new JButton();
    JButton noButton = new JButton();
    Border totalBorder = BorderFactory.createMatteBorder(3,3,3,3,new Color(61,54,62));




    public static void updateTextPane(JTextPane label,String text){
        label.setText("<html><center><b><i><font size=6 face=Calibri colour=rgb(61,54,62)>"+text+"</font></i></b></center></html>");
    }

    public static void updateLabel(JLabel label,String text){
        label.setText(text);
    }



}
