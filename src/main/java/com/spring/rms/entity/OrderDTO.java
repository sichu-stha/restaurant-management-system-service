package com.spring.rms.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;

	private int quantity;

	private BigDecimal totalPrice;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderDTO [item=" + item + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}

	
}
