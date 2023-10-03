package br.com.lojavinho.model;

public class Vinho {

    private String id;

    private String name;

    public Vinho(String name) {
        this.name = name;
    }

    public Vinho(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
