package seedu.address.testutil;

import seedu.address.model.ClientHub;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building ClientHub objects.
 * Example usage: <br>
 *     {@code ClientHub ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private ClientHub clientHub;

    public AddressBookBuilder() {
        clientHub = new ClientHub();
    }

    public AddressBookBuilder(ClientHub clientHub) {
        this.clientHub = clientHub;
    }

    /**
     * Adds a new {@code Person} to the {@code ClientHub} that we are building.
     */
    public AddressBookBuilder withPerson(Person person) {
        clientHub.addPerson(person);
        return this;
    }

    public ClientHub build() {
        return clientHub;
    }
}
