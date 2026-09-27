import adapter.LegacySkinCareAdapter;
import exception.TreatmentException;
import legacy.LegacySkinCareSystem;
import model.TreatmentRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreatmentExceptionTest {

    @Test
    void unknownServiceCodeShouldThrowException() {

        LegacySkinCareSystem legacySystem =
                new LegacySkinCareSystem();

        LegacySkinCareAdapter adapter =
                new LegacySkinCareAdapter(legacySystem);

        TreatmentRequest request =
                new TreatmentRequest(
                        "CLIENT-003",
                        "UNKNOWN_SERVICE",
                        30
                );

        assertThrows(
                TreatmentException.class,
                () -> adapter.perform(request)
        );
    }
}
