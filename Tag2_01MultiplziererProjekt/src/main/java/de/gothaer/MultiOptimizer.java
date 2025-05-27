package de.gothaer;

public class MultiOptimizer implements Multi{

    private final Multi multi;

    public MultiOptimizer(final Multi multi) {
        this.multi = multi;
    }

    @Override
    public long multipliziere(final int a, final int b) {
        if (a > b)
            return multi.multipliziere(b, a);
        return multi.multipliziere(a, b);
    }
}
