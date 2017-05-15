package com.trace.model;

public class AdminProduct {
	
	private Integer adminId;
	
	private Integer productId;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "AdminProduct [adminId=" + adminId + ", productId=" + productId + "]";
	}
	
}
