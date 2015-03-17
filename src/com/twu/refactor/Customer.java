package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
        String statement = "Rental Record for " + getName() + "\n";
		for(Rental rental : rentalList) {
			double thisAmount = 0;
			thisAmount = rental.getAmountFor(thisAmount);
            frequentRenterPoints += rental.getFrequentRenterPoints();
            statement += getRentalSubtotal(thisAmount, rental);
            totalAmount += thisAmount;
		}
        statement = getSummary(totalAmount, frequentRenterPoints, statement);
		return statement;
	}

    private String getSummary(double totalAmount, int frequentRenterPoints, String statement) {
        statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

    private String getRentalSubtotal(double thisAmount, Rental rental) {
        String statement;
        statement = "\t" + rental.movie.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
        return statement;
    }

    public String htmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = rentalList.iterator();
        String statement = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>";
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental rental = rentals.next();
            thisAmount = rental.getAmountFor(thisAmount);
            frequentRenterPoints += rental.getFrequentRenterPoints();
            statement += getRentalSubtotalHtml(thisAmount, rental);
            totalAmount += thisAmount;
        }
        statement = getHtmlSummary(totalAmount, frequentRenterPoints, statement);
        return statement;
    }

    private String getRentalSubtotalHtml(double thisAmount, Rental rental) {
        String statement;
        statement = "" + rental.movie.getMovie().getTitle() + ": "
                + String.valueOf(thisAmount) + "<BR>";
        return statement;
    }

    private String getHtmlSummary(double totalAmount, int frequentRenterPoints, String statement) {
        statement += "<P>You owe <EM>" + String.valueOf(totalAmount) + "</EM><P>";
        statement += "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points<P>";
        return statement;
    }
}