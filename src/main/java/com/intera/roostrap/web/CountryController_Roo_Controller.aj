// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.intera.roostrap.web;

import com.intera.roostrap.domain.City;
import com.intera.roostrap.domain.Country;
import com.intera.roostrap.web.CountryController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect CountryController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String CountryController.create(@Valid Country country, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, country);
            return "countries/create";
        }
        uiModel.asMap().clear();
        country.persist();
        return "redirect:/countries/" + encodeUrlPathSegment(country.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String CountryController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Country());
        return "countries/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String CountryController.show(@PathVariable("id") String id, Model uiModel) {
        uiModel.addAttribute("country", Country.findCountry(id));
        uiModel.addAttribute("itemId", id);
        return "countries/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String CountryController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("countries", Country.findCountryEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Country.countCountries() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("countries", Country.findAllCountries(sortFieldName, sortOrder));
        }
        return "countries/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String CountryController.update(@Valid Country country, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, country);
            return "countries/update";
        }
        uiModel.asMap().clear();
        country.merge();
        return "redirect:/countries/" + encodeUrlPathSegment(country.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String CountryController.updateForm(@PathVariable("id") String id, Model uiModel) {
        populateEditForm(uiModel, Country.findCountry(id));
        return "countries/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String CountryController.delete(@PathVariable("id") String id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Country country = Country.findCountry(id);
        country.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/countries";
    }
    
    void CountryController.populateEditForm(Model uiModel, Country country) {
        uiModel.addAttribute("country", country);
        uiModel.addAttribute("cities", City.findAllCities());
    }
    
    String CountryController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
