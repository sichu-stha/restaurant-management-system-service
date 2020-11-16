package com.spring.rms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderPaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private User user;
	private BigDecimal billAmount;
	private List<OrderDTO> items;
	
	public List<OrderDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderDTO> items) {
		this.items = items;
	}

	
	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "OrderPaymentDTO [items=" + items + ", billAmount=" + billAmount + ", user=" + user + "]";
	}
}
