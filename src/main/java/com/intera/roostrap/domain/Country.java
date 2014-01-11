package com.intera.roostrap.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@RooPlural("Countries")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = String.class, versionType = Long.class)
// gae
// @RooJpaActiveRecord //tomcat
public class Country {

	@NotNull
	private String name;

	private boolean isActive;

	@Size(max = 500)
	private String description;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "country", fetch = FetchType.LAZY)
	private Set<City> cities = new HashSet<City>();

	@Override
	public String toString() {
		return this.name;
	}

	@Transactional
	public void remove() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		if (this.entityManager.contains(this)) {
			this.removeCities(this);
			this.entityManager.remove(this);
		} else {
			Country attached = Country.findCountry(this.getId());
			this.removeCities(attached);
			this.entityManager.remove(attached);
		}
	}

	/**
	 * Deletes all the cities for a country (instead JDO CascadeType.REMOVE for Datanucleaus in GAE)
	 */
	void removeCities(Country country) {
		TypedQuery<City> cities = City.findCitiesByCountry(country);
		for (City city : cities.getResultList()) {
			city.remove();
		}
	}
}
