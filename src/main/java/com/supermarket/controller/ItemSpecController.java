package com.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarket.domain.ItemSpec;
import com.supermarket.service.ItemSpecService;

@Controller
@RequestMapping(value = "/itemspec")
public class ItemSpecController {
	
	private static final String LIST_VIEW = "itemSpec/list";
	private static final String REDIRECT = "redirect:/itemspec";
	
	@Autowired
	private ItemSpecService itemSpecService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(final Model model) {
        // Display blacklist
        model.addAttribute("items", this.itemSpecService.list());
        return LIST_VIEW;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public String update(@RequestParam("name") final String name,
            @RequestParam("price") final double price, 
            @RequestParam("specialPrice") final double specialPrice,
            @RequestParam("unit") final int unit, final Model model) {
		this.itemSpecService.update(new ItemSpec(name, price, specialPrice, unit));
		return REDIRECT;
	}

}