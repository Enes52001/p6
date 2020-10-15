package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_nummer")
    private int product_nummer;

    @Column(name = "naam")
    private String naam;

    @Column(name = "beschrijving")
    private String beschrijving;

    @Column(name = "prijs")
    private double prijs;

    @ManyToMany
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = @JoinColumn(name = "product_nummer"),
            inverseJoinColumns = @JoinColumn(name = "kaart_nummer")
    )
    private List<OVChipkaart> ov;

    public Product(int product_nummer, String naam, String beschrijving, double prijs){
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }
    public Product(){
        super();
    }

    public double getPrijs() {
        return prijs;
    }

    public void addOv(model.OVChipkaart ov) {
        this.ov.add(ov);
    }


    public int getProduct_nummer() {
        return product_nummer;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getNaam() {
        return naam;
    }

    public List<model.OVChipkaart> getOv() {
        return ov;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_nummer=" + product_nummer +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
