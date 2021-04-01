package com.cpg.onlineVegetableApp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;


@Entity
@Table(name=" Orders")
public class Order {
	@Id
	private int orderNo;
	private int custId;
	private double totalAmount;
	private LocalDate orderDate;
	private String status;
	
	@OneToMany 
	private List<VegetableDTO> vegList;
	
	public Order() {
		super();
	}

	public Order(int orderNo, int custId, double totalAmount, LocalDate orderDate, String status,
			List<VegetableDTO> vegList) {
		super();
		this.orderNo = orderNo;
		this.custId = custId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
		this.vegList = vegList;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<VegetableDTO> getVegList() {
		return vegList;
	}

	public void setVegList(List<VegetableDTO> vegList) {
		this.vegList = vegList;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", custId=" + custId + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + ", status=" + status + ", vegList=" + vegList + "]";
	}

	

	
	
	
	
	

}
