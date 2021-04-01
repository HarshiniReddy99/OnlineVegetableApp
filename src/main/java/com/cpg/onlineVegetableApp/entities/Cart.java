package com.cpg.onlineVegetableApp.entities;

import java.util.List;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Cart")
public class Cart {
	@Id
	
	private int cartId;
	private int custId;
	@OneToMany 
	private List<VegetableDTO> vegetables;
	public Cart() {
		super();
	}
	public Cart(int cartId, int custId, List<VegetableDTO> vegetables) {
		super();
		this.cartId = cartId;
		this.custId = custId;
		this.vegetables = vegetables;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public List<VegetableDTO> getVegetables() {
		return vegetables;
	}
	public void setVegetables(List<VegetableDTO> vegetables) {
		this.vegetables = vegetables;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", custId=" + custId + ", vegetables=" + vegetables + "]";
	}
	

}
