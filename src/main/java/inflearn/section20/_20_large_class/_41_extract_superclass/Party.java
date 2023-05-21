package inflearn.section20._20_large_class._41_extract_superclass;

public abstract class Party {

    protected String name;

    public String getName() {
        return name;
    }

    public double annualCost() {
        return this.monthlyCost() * 12;
    }

    abstract protected double monthlyCost();
}
