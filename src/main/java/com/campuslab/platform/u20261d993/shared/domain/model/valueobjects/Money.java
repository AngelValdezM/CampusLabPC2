package com.acme.platform.u202000000.shared.domain.model.valueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Value object that represents an amount of money in a given currency.
 *
 * @param value    the amount; it must be greater than or equal to zero
 * @param currency the currency code (e.g. PEN, USD); it cannot be null or blank
 * @author Angel Valdez
 */
public record Money(BigDecimal value, String currency) {

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    /**
     * Validates the money invariants.
     *
     * @throws IllegalArgumentException if the value is null or negative, or the currency is null or blank
     */
    public Money {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money value must be greater than or equal to zero");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Money currency cannot be null or blank");
        }
        currency = currency.trim().toUpperCase();
    }

    /**
     * Applies a percentage discount to this amount.
     *
     * @param percentage the discount percentage, between 0 and 100
     * @return a new {@link Money} with the discounted value and the same currency
     * @throws IllegalArgumentException if the percentage is null or outside the 0-100 range
     */
    public Money applyDiscount(BigDecimal percentage) {
        if (percentage == null || percentage.compareTo(BigDecimal.ZERO) < 0 || percentage.compareTo(ONE_HUNDRED) > 0) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        var discount = value.multiply(percentage).divide(ONE_HUNDRED, 2, RoundingMode.HALF_UP);
        return new Money(value.subtract(discount), currency);
    }
}
