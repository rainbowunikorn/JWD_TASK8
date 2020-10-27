package com.epam.task8.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="AbstractCandy")
@XmlSeeAlso({
        ChocolateCandy.class,
        Lollipop.class
})
public abstract class AbstractCandy {

    @XmlAttribute(name = "id",required = true)
    private int id;
   @XmlElement(name="name",required = true)
    private String name;
   @XmlElement(name="ingredients")
    private String ingredient;
   @XmlElement(name="country")
    private String country;

    public AbstractCandy() {

    }

    public AbstractCandy(int id, String name, String ingredient, String country) {
        this.id = id;
        this.name = name;
        this.ingredient = ingredient;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCandy that = (AbstractCandy) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredient, country);
    }

    @Override
    public String toString() {
        return "AbstractCandy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
