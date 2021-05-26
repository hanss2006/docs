package com.ettiv.docs.domain;
import lombok.Data;
import org.hibernate.annotations.Type;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fio;

    @Type(type="encryptedString")
    private String address;
    @Type(type="encryptedString")
    private String phone;

    private Long postId;
    @ManyToOne
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    private Post post;

    private Long unitId;
    @ManyToOne
    @JoinColumn(name = "unitId", insertable = false, updatable = false)
    private Unit unit;
}
