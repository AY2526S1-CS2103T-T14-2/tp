package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Company in ClientHub.
 * Guarantees: immutable; is valid as declared in {@link #isValidCompanyName(String)} (String)}
 */
public class Company {
    public static final String MESSAGE_CONSTRAINTS =
            "Company should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the company must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    /**
     * Name of Company.
     */
    public final String value;

    /**
     * Constructor for Company.
     * @param name A valid company name
     */
    public Company(String name) {
        requireNonNull(name);
        checkArgument(isValidCompanyName(name), MESSAGE_CONSTRAINTS);
        this.value = name;
    }

    /**
     * Returns true if a given string is a valid company name.
     */
    public static boolean isValidCompanyName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Company)) {
            return false;
        }

        Company otherName = (Company) other;
        return value.equals(otherName.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
