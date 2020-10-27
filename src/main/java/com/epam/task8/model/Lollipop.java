package com.epam.task8.model;

import com.epam.task8.LollipopType;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lollipop",namespace = "http://www.example.com/candies")
public class Lollipop extends AbstractCandy {
    @XmlElement(namespace = "http://www.example.com/candies",required = true)
    private LollipopType appearance;

    public Lollipop() {

    }

    public Lollipop(int id, String name, String ingredient, String country, LollipopType appearance) {
        super(id, name, ingredient, country);
        this.appearance = appearance;
    }

    public void setAppearance(LollipopType appearance) {
        this.appearance = appearance;
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", ingredient='" + super.getIngredient() + '\'' +
                ", country='" + super.getCountry() + '\'' +
                ", appearance=" + appearance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lollipop lollipop = (Lollipop) o;
        return appearance == lollipop.appearance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appearance);
    }
}
