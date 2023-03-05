import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ModelTest {
    private Model model = new Model();
    private Monomial mon1;
    private Monomial mon2;
    private Polynomial pol1;
    private Polynomial pol2;
    private Polynomial pol3;
    private String pol1String;
    private String pol2String;
    private String pol3String;

    @Before
    public void beforeClass() {
        mon1 = new Monomial(2, 3);
        mon2 = new Monomial(2, 2);
        pol1String = new String("5*X^3-4*X^2+2*X^0");
        pol2String = new String("2*X^2-4*X^1");
        pol3String = new String("3*X^2+4*X^1");
        pol1 = model.stringToPolynomial(pol1String);
        pol2 = model.stringToPolynomial(pol2String);
        pol3 = model.stringToPolynomial(pol3String);
    }

    @Test
    public void addMonomialTest() {
        Monomial expected = new Monomial(2, 5);
        Monomial result = model.AddMonomial(mon1, mon2);
        System.out.println(result.getGrade() + result.getCoef());
        assertEquals(result.toString(), expected.toString());
    }

    @Test
    public void subMonomialTest() {
        Monomial expected = new Monomial(2, 1);
        Monomial result = model.SubMonomial(mon1, mon2);
        System.out.println(result.getGrade() + result.getCoef());
        assertEquals(result.toString(), expected.toString());
    }

    @Test
    public void mulMonomialTest() {
        Monomial expected = new Monomial(4, 6);
        Monomial result = model.MulMonomial(mon1, mon2);
        System.out.println(result.getGrade() + result.getCoef());
        assertEquals(result.toString(), expected.toString());
    }

    @Test
    public void divMonomialTest() {
        Monomial expected = new Monomial(0, 1.5);
        Monomial result = model.DivMonomial(mon1, mon2);
        System.out.println(result.getGrade() + result.getCoef());
        assertEquals(result.toString(), expected.toString());
    }

    @Test
    public void addPolTest() {
        String e = "5*X^3-2*X^2-4*X^1+2*X^0";
        Polynomial r = model.AddPol(pol1, pol2);
        String expected = model.polynomialToString(model.stringToPolynomial(e));
        String result = model.polynomialToString(r);
        assertEquals(expected, result);
    }

    @Test
    public void subPolTest() {
        String e = "5*X^3-6*X^2+4*X^1+2*X^0";
        Polynomial r = model.SubPol(pol1, pol2);
        String expected = model.polynomialToString(model.stringToPolynomial(e));
        String result = model.polynomialToString(r);
        assertEquals(expected, result);
    }

    @Test
    public void mulPolTest() {
        String e = "10*X^5-28*X^4+16*X^3+4*X^2-8*X^1";
        Polynomial r = model.MulPol(pol1, pol2);
        String expected = model.polynomialToString(model.stringToPolynomial(e));
        String result = model.polynomialToString(r);
        assertEquals(expected, result);
    }

    @Test
    public void divPolTest() {
        String expected = "Q = 2.5*X^1+3*X^0 | R =12*X^1+2*X^0";
        String result = model.DivPol(pol1, pol2);
        assertEquals(expected, result);
    }

    @Test
    public void derPolTest() {
        String e = "15*X^2-8*X^1";
        Polynomial r = model.DerPol(pol1);
        String expected = model.polynomialToString(model.stringToPolynomial(e));
        String result = model.polynomialToString(r);
        assertEquals(expected, result);
    }

    @Test
    public void intPolTest() {
        String e = "1*X^3+2*X^2";
        Polynomial r = model.IntPol(pol3);
        String expected = model.polynomialToString(model.stringToPolynomial(e));
        String result = model.polynomialToString(r);
        assertEquals(expected, result);
    }
}