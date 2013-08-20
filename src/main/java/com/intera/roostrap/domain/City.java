package com.intera.roostrap.domain;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = String.class, versionType = Long.class) //gae
//@RooJpaActiveRecord //tomcat
public class City {

	@NotNull
    private String name;

    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}
