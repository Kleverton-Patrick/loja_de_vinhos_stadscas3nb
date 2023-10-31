package br.com.lojavinho.model;
///
public class Vinho {

    private String id;
    private String name;
    private String description;
    private String image;


    public Vinho(String id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }
}
