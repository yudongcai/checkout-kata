package com.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.supermarket.domain.Basket;
import com.supermarket.service.CheckoutService;
import com.supermarket.service.ItemSpecService;

@Controller
@RequestMapping(value = "/checkout")
@SessionAttributes("basket")
public class CheckoutController {
	
	private static final String VIEW = "checkout";
	private static final String REDIRECT = "redirect:/checkout";
	
	@Autowired
	private CheckoutService checkoutService;
	
	@Autowired
	private ItemSpecService itemSpecService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(final Model model) {
        // Display blacklist
        model.addAttribute("items", this.itemSpecService.list());
        if(!model.containsAttribute("basket")) {
        	model.addAttribute("basket", new Basket());
        }
        return VIEW;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public String update(@ModelAttribute("basket") Basket basket, @RequestParam("name") final String name, final Model model) {
		basket.addItem(name);
		this.checkoutService.checkout(basket);
		return REDIRECT;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public String delete(@ModelAttribute("basket") Basket basket, final Model model) {
		basket.emptyBasket();
		return REDIRECT;
	}
}