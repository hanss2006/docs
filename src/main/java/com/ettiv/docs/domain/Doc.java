package com.ettiv.docs.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regNum;
    private String name;
    private Date reg;
    private Date out;
    private String link;
    @Lob
    private String note;

    private Long vidId;
    @ManyToOne
    @JoinColumn(name = "vidId", insertable = false, updatable = false)
    private VidDoc vidDoc;

    private Long typeDocId;
    @ManyToOne
    @JoinColumn(name = "typeDocId", insertable = false, updatable = false)
    private TypeDoc typeDoc;

    private Long orgId;
    @ManyToOne
    @JoinColumn(name = "orgId", insertable = false, updatable = false)
    private Org org;

    private Long employeeId;
    @ManyToOne
    @JoinColumn(name = "employeeId", insertable = false, updatable = false)
    private Employee employee;
}

