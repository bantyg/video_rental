package com.twu.refactor;

public class Rental {

    Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getAmountFor(double rentalAmount) {
        switch (movie.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (getDaysRented() > 2)
                    rentalAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (getDaysRented() > 3)
                    rentalAmount += (getDaysRented() - 3) * 1.5;
                break;

        }
        return rentalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if ((movie.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}