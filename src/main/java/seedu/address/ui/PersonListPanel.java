package seedu.address.ui;

import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> id;
    @FXML
    private TableColumn<Person, String> name;
    @FXML
    private TableColumn<Person, String> phone;
    @FXML
    private TableColumn<Person, String> email;
    @FXML
    private TableColumn<Person, String> address;
    @FXML
    private TableColumn<Person, String> companyName;
    @FXML
    private TableColumn<Person, String> status;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);
        personTableView.setItems(personList);
        personTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setColumns();
    }

    /**
     * Sets the columns for each {@code Person} within the {@code PersonListPanel}.
     * Each row contains all the fields of {@code Person} for a specific individual.
     */
    public void setColumns() {
        id.setCellValueFactory(cell -> new SimpleStringProperty(
                String.valueOf(cell.getTableView().getItems().indexOf(cell.getValue()) + 1)));
        name.setCellValueFactory(cell -> new SimpleStringProperty(
                cell.getValue().getName().fullName));
        phone.setCellValueFactory(cell -> new SimpleStringProperty(
                cell.getValue().getPhone().value));
        email.setCellValueFactory(cell -> new SimpleStringProperty(
                cell.getValue().getEmail().value));
        address.setCellValueFactory(cell -> new SimpleStringProperty(
                cell.getValue().getAddress().value));
        companyName.setCellValueFactory(cell -> new SimpleStringProperty(
                "<COMPANY NAME>"));
        status.setCellValueFactory(cell -> new SimpleStringProperty(
                "<STATUS>"));
    }

}
