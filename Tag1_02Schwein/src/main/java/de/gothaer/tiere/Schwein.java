package de.gothaer.tiere;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Objects;

@Data
public class Schwein {

    private String name;
    @Setter(AccessLevel.PRIVATE)
    private int gewicht;


    public Schwein() {
        this("Nobody");
    }

    public Schwein(final String name) {
        setName(name);
        this.gewicht = 10;
    }

    public final void setName(final String name) {
        if(name.equalsIgnoreCase("elsa")) throw new IllegalArgumentException("Elsa ist nicht erlaubt");
        this.name = name;
    }

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }


}
