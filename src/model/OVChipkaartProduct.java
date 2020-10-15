package model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "OVChipkaartProduct")
@Table(name = "ov_chipkaart_product")
public class OVChipkaartProduct {
    @Id
    @Column(name = "kaart_nummer")
    @ManyToOne
    private OVChipkaart ov;

    @Id
    @Column(name = "product_nummer")
    @ManyToOne
    private Product product;

    @Column(name = "status")
    private String status;

    @Column(name = "last_geupdate")
    private Date lastUpdate;




}
