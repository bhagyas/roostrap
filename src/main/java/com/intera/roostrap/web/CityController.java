package com.intera.roostrap.web;
import com.intera.roostrap.domain.City;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cities")
@Controller
@RooWebScaffold(path = "cities", formBackingObject = City.class)
public class CityController {
}
