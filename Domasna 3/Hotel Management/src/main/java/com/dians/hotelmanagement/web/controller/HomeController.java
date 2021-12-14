package com.dians.hotelmanagement.web.controller;

import com.dians.hotelmanagement.model.City;
import com.dians.hotelmanagement.model.Hotel;
import com.dians.hotelmanagement.service.CityService;
import com.dians.hotelmanagement.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping(value = "/")
public class HomeController {
    private final CityService cityService;
    private final HotelService hotelService;

    public HomeController(CityService cityService, HotelService hotelService) {
        this.cityService = cityService;
        this.hotelService = hotelService;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String getHomePage(Model model, @RequestParam(required = false) String searchText) {
        if (searchText != null && !searchText.isEmpty()) {
//            List<Hotel> hotelsInCity = this.hotelService.findAllHotelsInCity(searchText);
//
//            Double[] longitudes = new Double[hotelsInCity.size()];
//            Double[] latitudes = new Double[hotelsInCity.size()];
//            String[] hotelNames = new String[hotelsInCity.size()];
//            IntStream.range(0, hotelsInCity.size())
//                    .forEach(i -> {
//                        longitudes[i] = hotelsInCity.get(i).getLongitude();
//                        latitudes[i] = hotelsInCity.get(i).getLatitude();
//                        hotelNames[i] = hotelsInCity.get(i).getName();
//                    });
//            model.addAttribute("longitudes", longitudes);
//            model.addAttribute("latitudes", latitudes);
//            model.addAttribute("hotelNames", hotelNames);
//
//            model.addAttribute("city", searchText);
//            model.addAttribute("hotels", hotelsInCity);
//            model.addAttribute("bodyContent","city");
            return "master-template";
        }
        List<City> cities = this.cityService.findAll();
        model.addAttribute("cities", cities);
        List<Hotel> mostVisitedHotels = this.hotelService.findMostVisitedHotels();
        model.addAttribute("mostVisitedHotels", mostVisitedHotels);
        model.addAttribute("bodyContent","home");
        return "master-template";
    }
}
