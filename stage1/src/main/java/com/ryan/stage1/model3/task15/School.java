package com.ryan.stage1.model3.task15;

public class School implements Comparable<School>{

    private String name;

    private int rank;


    public School() {
    }

    public School(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(School o) {
        //字段rank作为比较条件
        return this.rank - o.getRank();
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
