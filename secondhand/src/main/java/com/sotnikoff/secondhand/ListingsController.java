package com.sotnikoff.secondhand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListingsController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/listings")
    public String showListings(Model model) {
        List<Listing> listings = listingService.getAllListings();
        model.addAttribute("listings", listings);
        model.addAttribute("listingsActive", "active");
        return "listings";
    }
}