package io.github.grooters.libraryseat.model;

public class Administrator {
    private int key;
    private String number,name;

    public Administrator(String number, String name,int key) {
        this.number = number;
        this.name = name;
        this.key=key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getNumber() {
        return number;
    }

    public void setNum(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
