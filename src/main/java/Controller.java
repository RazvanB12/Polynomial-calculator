import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model model;
    private int selection = 1;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.addButXListener(new butXListener());
        view.addBut0Listener(new but0Listener());
        view.addBut1Listener(new but1Listener());
        view.addBut2Listener(new but2Listener());
        view.addBut3Listener(new but3Listener());
        view.addBut4Listener(new but4Listener());
        view.addBut5Listener(new but5Listener());
        view.addBut6Listener(new but6Listener());
        view.addBut7Listener(new but7Listener());
        view.addBut8Listener(new but8Listener());
        view.addBut9Listener(new but9Listener());
        view.addButPlusListener(new butPlusListener());
        view.addButMinusListener(new butMinusListener());
        view.addButProductListener(new butProductListener());
        view.addButExpListener(new butExpListener());
        view.addButClrListener(new butClrListener());
        view.addButSwapListener(new butSwapListener());
        view.addButResetListener(new butResetListener());
        view.addButAddListener(new butAddListener());
        view.addButSubListener(new butSubListener());
        view.addButMulListener(new butMulListener());
        view.addButDivListener(new butDivListener());
        view.addButDerListener(new butDerListener());
        view.addButIntListener(new butIntListener());
    }

    class butXListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "X");
            else view.setTextQ(view.getTextQ() + "X");
        }
    }

    class but0Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "0");
            else view.setTextQ(view.getTextQ() + "0");
        }
    }

    class but1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "1");
            else view.setTextQ(view.getTextQ() + "1");
        }
    }

    class but2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "2");
            else view.setTextQ(view.getTextQ() + "2");
        }
    }

    class but3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "3");
            else view.setTextQ(view.getTextQ() + "3");
        }
    }

    class but4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "4");
            else view.setTextQ(view.getTextQ() + "4");
        }
    }

    class but5Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "5");
            else view.setTextQ(view.getTextQ() + "5");
        }
    }

    class but6Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "6");
            else view.setTextQ(view.getTextQ() + "6");
        }
    }

    class but7Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "7");
            else view.setTextQ(view.getTextQ() + "7");
        }
    }

    class but8Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "8");
            else view.setTextQ(view.getTextQ() + "8");
        }
    }

    class but9Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "9");
            else view.setTextQ(view.getTextQ() + "9");
        }
    }

    class butPlusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "+");
            else view.setTextQ(view.getTextQ() + "+");
        }
    }

    class butMinusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "-");
            else view.setTextQ(view.getTextQ() + "-");
        }
    }

    class butProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "*");
            else view.setTextQ(view.getTextQ() + "*");
        }
    }

    class butExpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) view.setTextP(view.getTextP() + "^");
            else view.setTextQ(view.getTextQ() + "^");
        }
    }

    class butClrListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) {
                String s = view.getTextP();
                if (s.length() > 0) s = s.substring(0, s.length() - 1);
                view.setTextP(s);
            } else {
                String s = view.getTextQ();
                if (s.length() > 0) s = s.substring(0, s.length() - 1);
                view.setTextQ(s);
            }
        }
    }

    class butSwapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) selection = 2;
            else selection = 1;
        }
    }

    class butResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setTextP("");
            view.setTextQ("");
            view.setTextR("");
            selection = 1;
        }
    }

    class butAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getTextP();
            String s2 = view.getTextQ();
            Polynomial p = model.stringToPolynomial(s1);
            Polynomial q = model.stringToPolynomial(s2);
            Polynomial result = model.AddPol(p, q);
            String s = model.polynomialToString(result);
            view.setTextR(s);
        }
    }

    class butSubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getTextP();
            String s2 = view.getTextQ();
            Polynomial p = model.stringToPolynomial(s1);
            Polynomial q = model.stringToPolynomial(s2);
            Polynomial result = model.SubPol(p, q);
            String s = model.polynomialToString(result);
            view.setTextR(s);
        }
    }

    class butMulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getTextP();
            String s2 = view.getTextQ();
            Polynomial p = model.stringToPolynomial(s1);
            Polynomial q = model.stringToPolynomial(s2);
            Polynomial result = model.MulPol(p, q);
            String s = model.polynomialToString(result);
            view.setTextR(s);
        }
    }

    class butDivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getTextP();
            String s2 = view.getTextQ();
            Polynomial p = model.stringToPolynomial(s1);
            Polynomial q = model.stringToPolynomial(s2);
            String s = model.DivPol(p, q);
            view.setTextR(s);
        }
    }

    class butDerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) {
                String s = view.getTextP();
                Polynomial p = model.stringToPolynomial(s);
                Polynomial result = model.DerPol(p);
                String r = model.polynomialToString(result);
                view.setTextR(r);
            } else {
                String s = view.getTextQ();
                Polynomial p = model.stringToPolynomial(s);
                Polynomial result = model.DerPol(p);
                String r = model.polynomialToString(result);
                view.setTextR(r);
            }
        }
    }

    class butIntListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selection == 1) {
                String s = view.getTextP();
                Polynomial p = model.stringToPolynomial(s);
                Polynomial result = model.IntPol(p);
                String r = model.polynomialToString(result);
                r = r + "+const";
                view.setTextR(r);
            } else {
                String s = view.getTextQ();
                Polynomial p = model.stringToPolynomial(s);
                Polynomial result = model.IntPol(p);
                String r = model.polynomialToString(result);
                r = r + "+const";
                view.setTextR(r);
            }
        }
    }
}
