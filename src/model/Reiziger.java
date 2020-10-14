package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "Reiziger")
@Table(name = "reiziger")
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int id;

    @Column(name = "voorletters")
    private String voorletters;

    @Column(name = "tussenvoegsel")
    private String tussenvoegsel;

    @Column(name = "achternaam")
    private String achternaam;

    @Column(name = "geboortedatum")
    private Date geboortedatum;

    @OneToOne(
            mappedBy = "reiziger",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private model.Adres adres;


    @OneToMany(mappedBy = "reiziger", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<model.OVChipkaart> ov;

    public Reiziger(int id, String v, String t, String a, Date g) {
        this.id = id;
        this.voorletters = v;
        this.tussenvoegsel = t;
        this.achternaam = a;
        this.geboortedatum = g;

    }
    public Reiziger(){
        super();
    }

    public List<model.OVChipkaart> getOv() {
        return ov;
    }

    public void addOV(model.OVChipkaart ovc) {
        ov.add(ovc);
    }

    public int getId(){
        return id;
    }

    public void setAdres(model.Adres adres) {
        this.adres = adres;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getNaam(){
        return voorletters+" "+tussenvoegsel+" "+achternaam;
    }

    @Override
    public String toString() {
        String tv;
        if(tussenvoegsel == null){
            tv = "";

        }else{
            tv = tussenvoegsel;
        }
        return
                "id = " + id +
                        " naam:'" + voorletters +" "+ tv +" "+ achternaam +
                        ", geboortedatum: " + geboortedatum+
                        ", ov's: " + ov;
    }
}
