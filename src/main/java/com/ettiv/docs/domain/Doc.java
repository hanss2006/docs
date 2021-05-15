package com.ettiv.docs.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String regNum;
    private String name;
    private Date reg;
    private Date out;
    private String link;
    @Lob
    private String note;

    private Integer vidId;
    @ManyToOne
    @JoinColumn(name = "vidId", insertable = false, updatable = false)
    private VidDoc vidDoc;

    private Integer typeDocId;
    @ManyToOne
    @JoinColumn(name = "typeDocId", insertable = false, updatable = false)
    private TypeDoc typeDoc;

    private Integer orgId;
    @ManyToOne
    @JoinColumn(name = "orgId", insertable = false, updatable = false)
    private Org org;

    private Integer employeeId;
    @ManyToOne
    @JoinColumn(name = "employeeId", insertable = false, updatable = false)
    private Employee employee;
}

