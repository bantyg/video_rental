package com.twu.refactor;

public class Movie {
	public static final int  CHILDRENS = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;

	private String title;

    public int getPriceCode() {
        return priceCode;
    }

    private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

    public void setPriceCode(int arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

    public Movie getMovie() {
        return this;
    }
}

