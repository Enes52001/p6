package model;

import javax.persistence.*;

@Entity(name = "OVChipkaartProduct")
public class OVChipkaartProduct {
    @Id
    @ManyToOne
    private OVChipkaart ov;

    @Id
    @ManyToOne
    private Product product;


}
