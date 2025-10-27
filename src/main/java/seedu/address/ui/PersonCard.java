package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved
     * keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The
     *      issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label companyName;
    @FXML
    private FlowPane status;
    @FXML
    private FlowPane products;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to
     * display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().value);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);
        companyName.setText(person.getCompany().value);
        status.getChildren().add(handleStatusLabel(person));
        person.getProducts().stream()
                .sorted(Comparator.comparing(product -> product.productName))
                .forEach(product -> products.getChildren().add(new Label(product.productName)));
    }

    /**
     * Creates and returns a styled {@code Label} representing the given {@code Person}'s status.
     * The style depends on the status value ("uncontacted", "inprogress", "unsucessful", "successful").
     *
     * @param person The person whose status should be displayed.
     * @return A {@code Label} containing the {@code Person}'s status displayed in text, with appropriate styling.
     */
    public Label handleStatusLabel(Person person) {
        Label statusLabel = new Label(person.getStatus().value);
        String status = person.getStatus().value.toLowerCase();
        switch (status) {
        case "uncontacted":
            statusLabel.getStyleClass().add("status-uncontacted");
            break;
        case "inprogress":
            statusLabel.getStyleClass().add("status-inprogress");
            break;
        case "unsuccessful":
            statusLabel.getStyleClass().add("status-unsuccessful");
            break;
        case "successful":
            statusLabel.getStyleClass().add("status-successful");
            break;
        default:
            break;
        }
        return statusLabel;
    }
}
