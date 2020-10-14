package model;

import javax.persistence.*;

@Entity(name = "Adres")
@Table(name = "adres")
public class Adres {
    @Id
    @Column(name = "adres_id")
    private int adres_id;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "huisnummer")
    private String huisnummer;

    @Column(name = "straat")
    private String straat;

    @Column(name = "woonplaats")
    private String woonplaats;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    public Adres(int adres_id, String postcode, String huisnr, String straat, String woonplaats){
        this.adres_id = adres_id;
        this.postcode = postcode;
        this.huisnummer = huisnr;
        this.straat = straat;
        this.woonplaats = woonplaats;
    }
    public Adres(){
        super();
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }


    @Override
    public String toString() {
        return "Adres{" +
                "adres_id=" + adres_id +
                ", postcode='" + postcode + '\'' +
                ", huisnummer='" + huisnummer + '\'' +
                ", straat='" + straat + '\'' +
                ", woonplaats='" + woonplaats + '\'' +
                ", reiziger id='" + reiziger.getId() + '\'' +
                '}';
    }
}
