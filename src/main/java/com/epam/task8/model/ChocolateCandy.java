package com.epam.task8.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="chocolate-candy")

public class ChocolateCandy extends AbstractCandy {

   @XmlElement(name="chocolate-percent")
    private int chocolatePercent;

    public ChocolateCandy() {
        super();
        this.chocolatePercent = 0;
    }

    public ChocolateCandy(int id, String name, String ingredient, String country, int chocolatePercent) {
        super(id, name, ingredient, country);
        this.chocolatePercent = chocolatePercent;
    }

    public void setChocolatePercent(int chocolatePercent) {
        this.chocolatePercent = chocolatePercent;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", ingredient='" + super.getIngredient() + '\'' +
                ", country='" + super.getCountry() + '\'' +
                ", chocolatePercent=" + chocolatePercent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChocolateCandy that = (ChocolateCandy) o;
        return chocolatePercent == that.chocolatePercent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chocolatePercent);
    }
}
