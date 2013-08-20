package com.intera.roostrap.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

import com.intera.roostrap.domain.Country;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}
	
    public Converter<Country, String> getCountryToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.intera.roostrap.domain.Country, java.lang.String>() {
            public String convert(Country country) {
            	if(country.getDescription() != null && !country.getDescription().isEmpty()){
            		return new StringBuilder().append(country.getName()).append(" - ").append(country.getDescription()).toString();
             	}else{
            		return new StringBuilder().append(country.getName()).toString();
             	}
            }
        };
    }
}
