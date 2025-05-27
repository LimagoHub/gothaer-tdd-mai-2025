package de.gothaer.tiere;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Objects;

@Data
public class Schwein {


    public static final int DEFAULT_WEIGHT = 10;
    private String name;
    @Setter(AccessLevel.PRIVATE)
    private int gewicht;


    public Schwein() {
        this("Nobody");
    }

    public Schwein(final String name) {
        setName(name);
        this.gewicht = DEFAULT_WEIGHT;
    }

    public final void setName(final String name) {
        if(name == null || name.equalsIgnoreCase("elsa")) throw new IllegalArgumentException("Unerlaubter Name");
        this.name = name;
    }

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }


}
