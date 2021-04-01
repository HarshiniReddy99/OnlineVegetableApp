package com.cpg.onlineVegetableApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.entities.Cart;

import com.cpg.onlineVegetableApp.entities.VegetableDTO;
import com.cpg.onlineVegetableApp.exception.CartIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;
import com.cpg.onlineVegetableApp.service.ICartService;

import io.swagger.annotations.Api;
@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/cart")
public class CartRest {
	
	@Autowired
	ICartService service;
	
	@PostMapping("/addtocart/{cartId}")
	public VegetableDTO addToCart(@PathVariable("cartId") int cartId,@RequestBody VegetableDTO item) throws CartIdNotFoundException {
		VegetableDTO veg=service.addToCart(cartId, item);
		 return veg;
		
	}
	@DeleteMapping("/remove/{cartId}/{vegId}")
	public Cart removeVegetable(@PathVariable("cartId") int cartId,@PathVariable("vegId") int vegId) throws VegetableIdNotFoundException {
		return service.removeVegetable(cartId,vegId);
		
	}
	@PutMapping("/updateinc/{cartId}/{vegId}/{quantity}")
	public Cart increaseVegQuantity(@PathVariable("cartId") int cartid, @PathVariable("vegId")int vegId,@PathVariable("quantity")int quantity) throws CartIdNotFoundException{
		return service.increaseVegQuantity(cartid,vegId,quantity);
		
	}
	@PutMapping("/updatedec/{cartId}/{vegId}/{quantity}")
	public Cart decreseVegQuantity(@PathVariable("cartId") int cartid, @PathVariable("vegId")int vegId,@PathVariable("quantity")int quantity) throws CartIdNotFoundException{
		return service.decreseVegQuantity(cartid,vegId,quantity);
		
	}
	@GetMapping("/all/{cartId}")
	public List<VegetableDTO> viewAllItems(@PathVariable int cartId) throws CartIdNotFoundException{
		 List<VegetableDTO> allvegetable=this.service.viewAllItems(cartId);
		 return allvegetable;
	}
	@DeleteMapping("/remove/{cartId}")
	public Cart removeAllItems(@PathVariable("cartId") int cartId) throws CartIdNotFoundException {
		return service.removeAllItems(cartId);
		
		
	}
	
	
	

}
