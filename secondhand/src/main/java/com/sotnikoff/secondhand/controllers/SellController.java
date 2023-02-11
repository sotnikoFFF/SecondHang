package com.sotnikoff.secondhand.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SellController {

    @GetMapping("/sell")
    public String sellPage(Model model) {
        model.addAttribute("sellActive", "active");
        return "sell";
    }

    @PostMapping("/sell")
    public String submitSellForm(String itemName, String description, String price, String category) {
        // Implement the logic to process the form submission here

        return "redirect:/";
    }
}