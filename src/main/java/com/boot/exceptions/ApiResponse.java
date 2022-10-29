package com.boot.exceptions;

public class ApiResponse {
	
	
	private String mesaage;
	private boolean status;




	public String getMesaage() {
		return mesaage;
	}
	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}




	public ApiResponse(String mesaage, boolean status) {
		super();
		this.mesaage = mesaage;
		this.status = status;
	}



	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "ApiResponse [mesaage=" + mesaage + ", status=" + status + "]";
	}




}
