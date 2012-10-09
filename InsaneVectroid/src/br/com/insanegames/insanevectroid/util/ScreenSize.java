package br.com.insanegames.insanevectroid.util;

public class ScreenSize {
	
	private int realWidth;
	private int realHeight;
	
	public ScreenSize(int realWidth, int realHeight) {
		this.realWidth = realWidth;
		this.realHeight = realHeight;
	}
	
	public int getRealWidth() {
		return realWidth;
	}
	public void setRealWidth(int realWidth) {
		this.realWidth = realWidth;
	}
	public int getRealHeight() {
		return realHeight;
	}
	public void setRealHeight(int realHeight) {
		this.realHeight = realHeight;
	}
	
	@Override
	public String toString() {
		return "ScreenSize [realWidth=" + realWidth + ", realHeight="
				+ realHeight + "]";
	}

}
