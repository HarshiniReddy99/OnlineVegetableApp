package com.cpg.onlineVegetableApp.service;

import java.util.List;

import com.cpg.onlineVegetableApp.entities.Cart;

import com.cpg.onlineVegetableApp.entities.VegetableDTO;
import com.cpg.onlineVegetableApp.exception.CartIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;


public interface ICartService {
	
	public VegetableDTO addToCart(int cartId,VegetableDTO item) throws CartIdNotFoundException ;
	public Cart removeVegetable(int cartId,int vegId) throws VegetableIdNotFoundException ;
	public Cart increaseVegQuantity(int cartid,int vegId,int quantity) throws CartIdNotFoundException ;
	public Cart decreseVegQuantity(int cartid,int vegId,int quantity) throws CartIdNotFoundException ;
	public List<VegetableDTO> viewAllItems(int cartId) throws CartIdNotFoundException;
	public Cart removeAllItems(int cart) throws CartIdNotFoundException ;
	public Cart addCart(Cart cart);
	public Cart viewCart(Cart cart);

}
