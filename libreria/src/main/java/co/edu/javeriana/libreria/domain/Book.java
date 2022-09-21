package co.edu.javeriana.libreria.domain;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String frontPage; // URL
    private String name;
    private String introduction;
    private String editorial;
    private String editionDate;
    private Integer quantityAvailable = 0;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String frontPage, String name, String introduction, String editorial, String editionDate, Integer quantityAvailable) {
        this.frontPage = frontPage;
        this.name = name;
        this.introduction = introduction;
        this.editorial = editorial;
        this.editionDate = editionDate;
        this.quantityAvailable = quantityAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrontPage() {
        return frontPage;
    }

    public void setFrontPage(String frontPage) {
        this.frontPage = frontPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        if (quantityAvailable >= 0) {
            this.quantityAvailable = quantityAvailable;
        } else {
            this.quantityAvailable = 0;
        }
    }
}
