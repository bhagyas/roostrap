package com.intera.roostrap.domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = String.class, versionType = Long.class) //gae
//@RooJpaActiveRecord //tomcat
public class Person {
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date birthday;
}
