public class Monomial implements Comparable<Monomial> {
    private int grade;
    private double coef;

    public Monomial(int g, double c) {
        this.grade = g;
        this.coef = c;
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "grade=" + grade +
                ", coef=" + coef +
                '}';
    }

    public int compareTo(Monomial m) { return m.getGrade() - this.getGrade(); }

    public int getGrade() { return grade; }

    public void setGrade(int grade) { this.grade = grade; }

    public Double getCoef() { return coef; }

    public void setCoef(Double coef) { this.coef = coef; }
}
