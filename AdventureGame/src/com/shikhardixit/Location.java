package com.shikhardixit;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationId;
    private final String Description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits){
        this.locationId = locationId;
        this.Description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        }else{
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q",0);
    }

//    public void addExit(String direction, int location){
//        exits.put(direction,location);
//    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return Description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);
    }
}
