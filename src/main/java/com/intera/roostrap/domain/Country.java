package com.intera.roostrap.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = String.class, versionType = Long.class)
public class Country {

	@NotNull
    private String name;

    private boolean isActive;

    @Size(max = 500)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<City> cities = new HashSet<City>();
    
    public String toString(){
    	return this.name;
    }
}
