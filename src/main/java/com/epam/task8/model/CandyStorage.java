package com.epam.task8.model;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="candy")
public class CandyStorage {

@XmlElements({@XmlElement( name="chocolate-candy",type = ChocolateCandy.class),
    @XmlElement(name = "lollipop",type = Lollipop.class)})
    private List<AbstractCandy> candyStorage = new ArrayList<>();

    public CandyStorage() {
    }
    public void setCandyStorage(List<AbstractCandy> candyStorage) {
        this.candyStorage = candyStorage;
    }

    @XmlTransient
    public List<AbstractCandy> getCandyStorage() {
        return candyStorage;
    }


    public boolean addCandy(AbstractCandy candy) {
        return candyStorage.add(candy);
    }

    @Override
    public String toString() {
        return "Candies [list=" + candyStorage + "]";
    }

}
