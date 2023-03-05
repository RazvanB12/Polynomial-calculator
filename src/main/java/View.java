import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JButton butX, but0, but1, but2, but3, but4, but5, but6, but7, but8, but9;
    private JButton butPlus, butMinus, butProduct, butExp, butAdd, butSub, butMul, butDiv, butDer, butInt, butClr, butSwap, butReset;
    private JLabel label, labelP, labelQ, labelR;
    private JTextField textP, textQ, textR;

    public View() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(315,340);

        butX = new JButton ("X");
        but0 = new JButton ("0");
        but1 = new JButton ("1");
        but2 = new JButton ("2");
        but3 = new JButton ("3");
        but4 = new JButton ("4");
        but5 = new JButton ("5");
        but6 = new JButton ("6");
        but8 = new JButton ("8");
        but7 = new JButton ("7");
        but9 = new JButton ("9");
        butPlus = new JButton ("+");
        butMinus = new JButton ("-");
        butProduct = new JButton ("*");
        butExp = new JButton ("^");
        butClr = new JButton ("clr");
        butAdd = new JButton ("ADD");
        butSub = new JButton ("SUB");
        butMul = new JButton ("MUL");
        butDiv = new JButton ("DIV");
        butDer = new JButton ("DER");
        butInt = new JButton ("INT");
        butSwap = new JButton ("SWAP");
        butReset = new JButton ("RESET");
        label = new JLabel ("POLYNOMIAL CALCULATOR");
        labelP = new JLabel ("P");
        labelQ = new JLabel ("Q");
        labelR = new JLabel ("R");
        textP = new JTextField (5);
        textQ = new JTextField (5);
        textR = new JTextField (5);

        butX.setBounds (0, 250, 50, 50);
        but8.setBounds (50, 200, 50, 50);
        but7.setBounds (0, 200, 50, 50);
        but9.setBounds (100, 200, 50, 50);
        but4.setBounds (0, 150, 50, 50);
        but5.setBounds (50, 150, 50, 50);
        but6.setBounds (100, 150, 50, 50);
        but1.setBounds (0, 100, 50, 50);
        but2.setBounds (50, 100, 50, 50);
        but3.setBounds (100, 100, 50, 50);
        butPlus.setBounds (150, 100, 50, 50);
        butMinus.setBounds (150, 150, 50, 50);
        butProduct.setBounds (150, 200, 50, 50);
        butExp.setBounds (150, 250, 50, 50);
        butClr.setBounds (100, 250, 50, 50);
        but0.setBounds (50, 250, 50, 50);
        butAdd.setBounds (200, 100, 100, 25);
        butSub.setBounds (200, 125, 100, 25);
        butMul.setBounds (200, 150, 100, 25);
        butDiv.setBounds (200, 175, 100, 25);
        butDer.setBounds (200, 200, 100, 25);
        butInt.setBounds (200, 225, 100, 25);
        butSwap.setBounds (200, 250, 100, 25);
        butReset.setBounds (200, 275, 100, 25);
        label.setBounds (65, 0, 165, 25);
        labelP.setBounds (25, 25, 25, 25);
        labelQ.setBounds (25, 50, 25, 25);
        labelR.setBounds (25, 75, 25, 25);
        textP.setBounds (50, 25, 200, 25);
        textQ.setBounds (50, 50, 200, 25);
        textR.setBounds (50, 75, 200, 25);

        panel.add (butX);
        panel.add (but0);
        panel.add (but1);
        panel.add (but2);
        panel.add (but3);
        panel.add (but4);
        panel.add (but5);
        panel.add (but6);
        panel.add (but7);
        panel.add (but8);
        panel.add (but9);
        panel.add (butPlus);
        panel.add (butMinus);
        panel.add (butProduct);
        panel.add (butExp);
        panel.add (butAdd);
        panel.add (butSub);
        panel.add (butMul);
        panel.add (butDiv);
        panel.add (butDer);
        panel.add (butInt);
        panel.add (butClr);
        panel.add (butSwap);
        panel.add (butReset);
        panel.add (label);
        panel.add (labelP);
        panel.add (labelQ);
        panel.add (labelR);
        panel.add (textP);
        panel.add (textQ);
        panel.add (textR);

        this.add(panel);
    }

    public void addButXListener (ActionListener listener){butX.addActionListener(listener);}

    public void addBut0Listener (ActionListener listener){but0.addActionListener(listener);}

    public void addBut1Listener (ActionListener listener){but1.addActionListener(listener);}

    public void addBut2Listener (ActionListener listener){but2.addActionListener(listener);}

    public void addBut3Listener (ActionListener listener){but3.addActionListener(listener);}

    public void addBut4Listener (ActionListener listener){but4.addActionListener(listener);}

    public void addBut5Listener (ActionListener listener){but5.addActionListener(listener);}

    public void addBut6Listener (ActionListener listener){but6.addActionListener(listener);}

    public void addBut7Listener (ActionListener listener){but7.addActionListener(listener);}

    public void addBut8Listener (ActionListener listener){but8.addActionListener(listener);}

    public void addBut9Listener (ActionListener listener){but9.addActionListener(listener);}

    public void addButPlusListener (ActionListener listener){butPlus.addActionListener(listener);}

    public void addButMinusListener (ActionListener listener){butMinus.addActionListener(listener);}

    public void addButProductListener (ActionListener listener){butProduct.addActionListener(listener);}

    public void addButExpListener (ActionListener listener){butExp.addActionListener(listener);}

    public void addButAddListener (ActionListener listener){butAdd.addActionListener(listener);}

    public void addButSubListener (ActionListener listener){butSub.addActionListener(listener);}

    public void addButMulListener (ActionListener listener){butMul.addActionListener(listener);}

    public void addButDivListener (ActionListener listener){butDiv.addActionListener(listener);}

    public void addButDerListener (ActionListener listener){butDer.addActionListener(listener);}

    public void addButIntListener (ActionListener listener){butInt.addActionListener(listener);}

    public void addButClrListener (ActionListener listener){butClr.addActionListener(listener);}

    public void addButSwapListener (ActionListener listener){butSwap.addActionListener(listener);}

    public void addButResetListener (ActionListener listener){butReset.addActionListener(listener);}

    public String getTextP() {return textP.getText();}

    public String getTextQ() {return textQ.getText();}

    public void setTextP(String s) {textP.setText(s);}

    public void setTextQ(String s) {textQ.setText(s);}

    public void setTextR(String s) {textR.setText(s);}
}

