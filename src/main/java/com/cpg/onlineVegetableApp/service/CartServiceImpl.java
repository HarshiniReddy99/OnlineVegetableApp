package com.cpg.onlineVegetableApp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpg.onlineVegetableApp.dao.ICartRepository;
import com.cpg.onlineVegetableApp.dao.IVegetableMgmtRepository;
import com.cpg.onlineVegetableApp.entities.Cart;
import com.cpg.onlineVegetableApp.entities.Vegetable;
import com.cpg.onlineVegetableApp.entities.VegetableDTO;
import com.cpg.onlineVegetableApp.exception.CartIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;


@Service
@Transactional
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartRepository cartRepository;
	
	@Autowired
	IVegetableMgmtRepository vegRepository;

	@Override
	public Cart removeVegetable(int cartId,int vegId) throws VegetableIdNotFoundException {
		
			Optional<Cart> optionalcart = cartRepository.findById(cartId);
			Cart cart2 = null;
			if (optionalcart.isPresent()) {
				cart2 = optionalcart.get();
				List<VegetableDTO> vegetableInCart = cart2.getVegetables();
				for (VegetableDTO veg : vegetableInCart) {
					if (veg.getVegId() == vegId) {
						cartRepository.deleteById(vegId);}
				}
				
				return cart2;
			} 
			else {
					throw new VegetableIdNotFoundException("vegetable with id"+vegId+"not found");
			}
		

	}

	@Override
	public Cart increaseVegQuantity(int cartid, int vegId, int quantity) throws CartIdNotFoundException {
		
			Cart cart = null;
			Optional<Cart> optionalcart = cartRepository.findById(cartid);
			if (optionalcart.isPresent()) {
				cart = optionalcart.get();
				List<VegetableDTO> vegetableInCart = cart.getVegetables();
				for (VegetableDTO veg : vegetableInCart) {
					if (veg.getVegId() == vegId) {
						veg.setQuantity(veg.getQuantity() + quantity);
					}
				}
				return cart;
				
				
			}
			else
			{
				throw new CartIdNotFoundException("Cart with id"+cartid+"not found Exception");
			}
			

	}

	@Override
	public Cart decreseVegQuantity(int cartid, int vegId, int quantity)throws CartIdNotFoundException{
		
			Cart cart = null;
			Optional<Cart> optionalcart = cartRepository.findById(cartid);
			if (optionalcart.isPresent()) {
				cart = optionalcart.get();
				List<VegetableDTO> vegetableInCart = cart.getVegetables();
				for (VegetableDTO veg : vegetableInCart) {
					if (veg.getVegId() == vegId) {
						veg.setQuantity(veg.getQuantity() - quantity);
					}
				}
				return cart;
			}
			else
			{
				throw new CartIdNotFoundException("Cart with id"+cartid+"not found Exception");
			}
			
		

	}

	@Override
	public List<VegetableDTO> viewAllItems(int cartId) throws CartIdNotFoundException {
		
			Optional<Cart> cartoptional = null;
			cartoptional = cartRepository.findById(cartId);
			if (cartoptional.isPresent()) {
				Cart cart2 = cartoptional.get();
				return cart2.getVegetables();
			}
			else
			{
				throw new CartIdNotFoundException("Cart with id"+cartId+"not found Exception");
			}

		
		
	}


	
	@Override
	public Cart removeAllItems(int cart)throws CartIdNotFoundException {
		
		Optional<Cart> cartoptional = null;
		cartoptional = cartRepository.findById(cart);
		if (cartoptional.isEmpty())
			{
			throw new CartIdNotFoundException("Cart with id "+ cart+" not found ");
		
			
			}
			cartRepository.deleteById(cart);
			return cartoptional.get();
		
	}

	@Override
	public VegetableDTO addToCart(int cartId, VegetableDTO item)throws CartIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Vegetable> optionalVeg = vegRepository.findById(item.getVegId());
		Optional<Cart> cart1=cartRepository.findById(cartId);
		if(cart1.isPresent())
		{
		if (optionalVeg.isPresent()) {
			
			cart1.get().getVegetables().add(item);
			cartRepository.saveAndFlush(cart1.get());
		}
		}
		else
		{
			throw new CartIdNotFoundException("Cart with id "+cartId+" not found Exception");
		}
		
		return item;

	}

	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public Cart viewCart(Cart cart) {
		// TODO Auto-generated method stub
		Optional<Cart> optionalcart=cartRepository.findById(cart.getCartId());
		return optionalcart.get();
	}
}
