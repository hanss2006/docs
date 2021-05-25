package com.ettiv.docs.domain;

import org.springframework.data.rest.core.config.Projection;
import java.util.Date;

@Projection(
        name = "docFull",
        types = { Doc.class })
public interface DocFull {
    Long getId();
    String getRegNum();
    String getName();
    String getReg();
    Date getOut();
    String getLink();
    String getNote();
    VidDoc getVidDoc();
    TypeDoc getTypeDoc();
    Org getOrg();
    Employee getEmployee();
}
