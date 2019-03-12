package utils;

import javax.persistence.Persistence;

public class TableBuilder {

    public static void main(String[] args) {
        System.out.println("Buliding Tabels....................................");
        Persistence.generateSchema("pu", null);
        System.out.println("Finish building tables!");
    }
    
}
