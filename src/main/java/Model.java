import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    public Monomial AddMonomial(Monomial m1, Monomial m2) {
        Monomial result = new Monomial(m1.getGrade(), m1.getCoef() + m2.getCoef());
        return result;
    }

    public Monomial SubMonomial(Monomial m1, Monomial m2) {
        Monomial result = new Monomial(m1.getGrade(), m1.getCoef() - m2.getCoef());
        return result;
    }

    public Monomial MulMonomial(Monomial m1, Monomial m2) {
        Monomial result = new Monomial(m1.getGrade() + m2.getGrade(), m1.getCoef() * m2.getCoef());
        return result;
    }

    public Monomial DivMonomial(Monomial m1, Monomial m2) {
        Monomial result = new Monomial(m1.getGrade() - m2.getGrade(), m1.getCoef() / m2.getCoef());
        return result;
    }

    public Polynomial stringToPolynomial(String s) {
        List<Monomial> l = new ArrayList<>();
        List<Integer> coefs = new ArrayList<>();
        List<Integer> grades = new ArrayList<>();
        s = s.replace("+", "|+");
        s = s.replace("-", "|-");
        List<String> elem = List.of(s.split("\\|"));
        for (String str : elem) {
            List<String> var = List.of(str.split("\\*X\\^"));
            coefs.add(Integer.parseInt(var.get(0)));
            grades.add(Integer.parseInt(var.get(1)));
        }
        while (!coefs.isEmpty() && !grades.isEmpty()) {
            Monomial m = new Monomial(grades.get(0), coefs.get(0));
            l.add(m);
            coefs.remove(0);
            grades.remove(0);
        }
        Polynomial p = new Polynomial(l);
        return p;
    }

    public String polynomialToString(Polynomial p) {
        DecimalFormat df = new DecimalFormat("#.##");
        String s = new String();
        List<Monomial> l = new ArrayList<Monomial>();
        l.addAll(p.getElements());
        for (Monomial m : l) {
            if (m.getCoef() > 0 && !s.isEmpty()) s = s + "+" + df.format(m.getCoef()) + "*X^" + m.getGrade();
            else if (m.getCoef() > 0) s = s + df.format(m.getCoef()) + "*X^" + m.getGrade();
            else s = s + df.format(m.getCoef()) + "*X^" + m.getGrade();
        }
        if (s.isEmpty()) s = "0";
        return s;
    }

    public Polynomial AddPol(Polynomial p1, Polynomial p2) {
        List<Monomial> r = new ArrayList<Monomial>();
        List<Monomial> l1 = new ArrayList<Monomial>();
        List<Monomial> l2 = new ArrayList<Monomial>();
        l1.addAll(p1.getElements());
        l2.addAll(p2.getElements());
        while (!l1.isEmpty() && !l2.isEmpty()) {
            Monomial m1 = l1.get(0);
            Monomial m2 = l2.get(0);
            Monomial m = new Monomial(0, 0);
            if (m1.getGrade() == m2.getGrade()) {
                m = AddMonomial(m1, m2);
                l1.remove(0);
                l2.remove(0);
            } else if (m1.getGrade() > m2.getGrade()) {
                m = m1;
                l1.remove(0);
            } else {
                m = m2;
                l2.remove(0);
            }
            if (m.getCoef() != 0) r.add(m);
        }
        while (!l1.isEmpty()) {
            Monomial m1 = l1.get(0);
            r.add(m1);
            l1.remove(0);
        }
        while (!l2.isEmpty()) {
            Monomial m2 = l2.get(0);
            r.add(m2);
            l2.remove(0);
        }
        Polynomial result = new Polynomial(r);
        return result;
    }

    public Polynomial SubPol(Polynomial p1, Polynomial p2) {
        List<Monomial> r = new ArrayList<Monomial>();
        List<Monomial> l1 = new ArrayList<Monomial>();
        List<Monomial> l2 = new ArrayList<Monomial>();
        l1.addAll(p1.getElements());
        l2.addAll(p2.getElements());
        while (!l1.isEmpty() && !l2.isEmpty()) {
            Monomial m1 = l1.get(0);
            Monomial m2 = l2.get(0);
            Monomial m = new Monomial(0, 0);
            if (m1.getGrade() == m2.getGrade()) {
                m = SubMonomial(m1, m2);
                l1.remove(0);
                l2.remove(0);
            } else if (m1.getGrade() > m2.getGrade()) {
                m = m1;
                l1.remove(0);
            } else {
                m.setGrade(m2.getGrade());
                m.setCoef(-m2.getCoef());
                l2.remove(0);
            }
            if (m.getCoef() != 0) r.add(m);
        }
        while (!l1.isEmpty()) {
            Monomial m1 = l1.get(0);
            r.add(m1);
            l1.remove(0);
        }
        while (!l2.isEmpty()) {
            Monomial m2 = l2.get(0);
            m2.setCoef(-m2.getCoef());
            r.add(m2);
            l2.remove(0);
        }
        Polynomial result = new Polynomial(r);
        return result;
    }

    public Polynomial MulPol(Polynomial p1, Polynomial p2) {
        List<Monomial> r = new ArrayList<Monomial>();
        List<Monomial> result = new ArrayList<Monomial>();
        List<Monomial> l1 = new ArrayList<Monomial>();
        List<Monomial> l2 = new ArrayList<Monomial>();
        l1.addAll(p1.getElements());
        l2.addAll(p2.getElements());
        for (Monomial x : l1) {
            for (Monomial y : l2) {
                Monomial m = MulMonomial(x, y);
                r.add(m);
            }
        }
        Collections.sort(r);
        Monomial mon = r.get(0);
        r.remove(0);
        for (Monomial m : r) {
            if (mon.getGrade() == m.getGrade()) {
                mon = AddMonomial(mon, m);
            } else {
                result.add(mon);
                mon = m;
            }
        }
        result.add(mon);
        Polynomial resultP = new Polynomial(result);
        return resultP;
    }

    public String DivPol(Polynomial p1, Polynomial p2) {
        List<Monomial> quotient = new ArrayList<Monomial>();
        Monomial m = DivMonomial(p1.getElements().get(0), p2.getElements().get(0));
        boolean exit = false;
        if (m.getGrade() < 0) exit = true;
        while (exit == false) {
            quotient.add(m);
            Polynomial p = new Polynomial(quotient);
            p = MulPol(p, p2);
            p = SubPol(p1, p);
            if (p.getElements().size() > 0) m = DivMonomial(p.getElements().get(0), p2.getElements().get(0));
            else exit = true;
            if (m.getGrade() < 0) exit = true;
        }
        Polynomial q = new Polynomial(quotient);
        Polynomial r = SubPol(p1, MulPol(q, p2));
        String s = "Q = " + polynomialToString(q) + " | R =" + polynomialToString(r);
        return s;
    }

    public Polynomial DerPol(Polynomial p) {
        List<Monomial> l = new ArrayList<Monomial>();
        l.addAll(p.getElements());
        for (Monomial m : l) {
            m.setCoef(m.getCoef() * m.getGrade());
            m.setGrade(m.getGrade() - 1);
        }
        if (l.get(l.size() - 1).getGrade() == -1) l.remove(l.size() - 1);
        Polynomial result = new Polynomial(l);
        return result;
    }

    public Polynomial IntPol(Polynomial p) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        String s = new String();
        List<Monomial> l = new ArrayList<Monomial>();
        l.addAll(p.getElements());
        for (Monomial m : l) {
            m.setCoef(m.getCoef() / (m.getGrade() + 1));
            m.setGrade(m.getGrade() + 1);
        }
        Polynomial result = new Polynomial(l);
        return result;
    }
}
