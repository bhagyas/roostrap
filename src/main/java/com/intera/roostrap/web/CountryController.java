package com.intera.roostrap.web;
import com.intera.roostrap.domain.Country;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/countries")
@Controller
@RooWebScaffold(path = "countries", formBackingObject = Country.class)
public class CountryController {
}
