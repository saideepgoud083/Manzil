package com.example.Manzil;




public class responcestucture<T> {
	
	private int statuscode ;
	private String masg;
	private T data ;
	public responcestucture() {
		super();
	}
	public responcestucture(int statuscode, String masg, T data) {
		super();
		this.statuscode = statuscode;
		this.masg = masg;
		this.data = data;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMasg() {
		return masg;
	}
	public void setMasg(String masg) {
		this.masg = masg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "responcestucture [statuscode=" + statuscode + ", masg=" + masg + ", data=" + data + "]";
	}
}
