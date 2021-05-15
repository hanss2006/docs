package com.ettiv.docs.domain;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fio;
    private String address;
    private String phone;

    private Integer postId;
    @ManyToOne
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    private Post post;

    private Integer unitId;
    @ManyToOne
    @JoinColumn(name = "unitId", insertable = false, updatable = false)
    private Unit unit;
}
