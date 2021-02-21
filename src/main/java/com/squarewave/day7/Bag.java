package com.squarewave.day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bag {

    private final String colour;
    private final Map<Bag, Integer> countByBag = new HashMap<>();

    public Bag(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void add(Bag bag, Integer count) {
        countByBag.put(bag, count);
    }

    public Set<Bag> bagContent() {
        return countByBag.keySet();
    }

    public Map<Bag, Integer> getCountByBag() {
        return countByBag;
    }
}
