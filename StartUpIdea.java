package com.example.workingdemo;

public class StartUpIdea implements Comparable<StartUpIdea> {
    private String problemA;
    private String targetA;
    private int badA;
    private int peopleA;
    private int bigA;
    private String compA;

    /**
     * 0 arg constructor that sets all variables to default value.
     */
    public StartUpIdea() {

    }

    /**
     * Getter method for problems.
     * @return String.
     */
    public String getProblemA() {
        return problemA;
    }

    /**
     * Setter method for problems.
     * @param problemA String.
     */
    public void setProblemA(String problemA) {
        this.problemA = problemA;
    }

    /**
     * Setter method for target.
     * @return String.
     */
    public String getTargetA() {
        return targetA;
    }

    /**
     * Sets target value.
     * @param targetA String.
     */
    public void setTargetA(String targetA) {
        this.targetA = targetA;
    }

    /**
     * Getter method for howBad
     * @return int.
     */
    public int getBadA() {
        return badA;
    }

    /**
     * Setter method for bad.
     * @param badA int.
     */
    public void setBadA(int badA) {
        this.badA = badA;
    }

    /**
     * Getter method for people.
     * @return int.
     */
    public int getPeopleA() {
        return peopleA;
    }

    /**
     * Setter method for people.
     * @param peopleA int.
     */
    public void setPeopleA(int peopleA) {
        this.peopleA = peopleA;
    }

    /**
     * Getter method for big.
     * @return int.
     */
    public int getBigA() {
        return bigA;
    }

    /**
     * Setter method for big.
     * @param bigA int.
     */
    public void setBigA(int bigA) {
        this.bigA = bigA;
    }

    /**
     * Getter method for comp.
     * @return String.
     */
    public String getCompA() {
        return compA;
    }

    /**
     * Setter method for comp.
     * @param compA String.
     */
    public void setCompA(String compA) {
        this.compA = compA;
    }

    /**
     * 6 arg constructor setting values for each variable.
     * @param problemA String.
     * @param targetA String.
     * @param badA int.
     * @param peopleA int.
     * @param bigA int.
     * @param compA String.
     */
    public StartUpIdea(String problemA, String targetA, int badA, int peopleA, int bigA, String compA) {
        this.problemA = problemA;
        this.targetA = targetA;
        this.badA = badA;
        this.peopleA = peopleA;
        this.bigA = bigA;
        this.compA = compA;
    }

    /**
     * Compare to method that compares two ideeas.
     * @param other the object to be compared.
     * @return int value.
     */
    public int compareTo(StartUpIdea other) {
        int customerD =
                this.badA * (this.bigA + this.peopleA * 10000)
                        - other.badA * (other.bigA + other.peopleA * 10000);
        return 0 - customerD;
    }

    /**
     * ToString method.
     * @return a String representation of the com.example.demo.StartUpIdea.
     */
    public String toString() {
        String str = "";
        str += "Problem: " + problemA + "\n";
        str += "Target Customer: " + targetA + "\n";
        str += "Customer Need: " + badA + "\n";
        str += "Known People With Problem: " + peopleA + "\n";
        str += "Target Market Size: " + bigA + "\n";
        str += "Competitors: " + compA + "\n";
        return str;
    }
}
