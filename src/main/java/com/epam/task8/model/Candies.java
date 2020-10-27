package com.epam.task8.model;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="candies")
public class Candies {

@XmlElements({@XmlElement( name="chocolate-candy",type = ChocolateCandy.class),
    @XmlElement(name = "lollipop",type = Lollipop.class)})
    private List<AbstractCandy> candies = new ArrayList<>();

    public Candies() {
    }
    public void setCandies(List<AbstractCandy> candies) {
        this.candies = candies;
    }

    @XmlTransient
    public List<AbstractCandy> getCandies() {
        return candies;
    }


    public boolean addCandy(AbstractCandy candy) {
        return candies.add(candy);
    }

    @Override
    public String toString() {
        return "Candies [list=" + candies + "]";
    }

}
