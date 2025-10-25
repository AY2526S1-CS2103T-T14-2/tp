package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ClientHub;
import seedu.address.model.ReadOnlyClientHub;

/**
 * Represents a storage for {@link ClientHub}.
 */
public interface AddressBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getAddressBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyClientHub}.
     * Returns {@code Optional.empty()} if storage file is not found.
     *
     * @throws DataLoadingException if loading the data from storage failed.
     */
    Optional<ReadOnlyClientHub> readAddressBook() throws DataLoadingException;

    /**
     * @see #getAddressBookFilePath()
     */
    Optional<ReadOnlyClientHub> readAddressBook(Path filePath) throws DataLoadingException;

    /**
     * Saves the given {@link ReadOnlyClientHub} to the storage.
     * @param clientHub cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveClientHub(ReadOnlyClientHub clientHub) throws IOException;

    /**
     * @see #saveClientHub(ReadOnlyClientHub)
     */
    void saveClientHub(ReadOnlyClientHub addressBook, Path filePath) throws IOException;

}
