package br.com.lojavinho.model;

public class Vinho {

    private String id;
    private String name;
    private String image;

    public Vinho(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vinho(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }
}
