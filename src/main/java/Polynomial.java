import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> elements = new ArrayList<Monomial>();

    public Polynomial(List<Monomial> e) { this.elements = e;
    }

    public List<Monomial> getElements() {
        return elements;
    }
}