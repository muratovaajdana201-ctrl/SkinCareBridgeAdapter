import adapter.LegacySkinCareAdapter;
import legacy.LegacySkinCareSystem;
import model.TreatmentRequest;
import model.TreatmentResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegacySkinCareAdapterTest {

    @Test
    void adapterShouldTranslateFacialCareRequest() {

        LegacySkinCareSystem legacySystem =
                new LegacySkinCareSystem();

        LegacySkinCareAdapter adapter =
                new LegacySkinCareAdapter(legacySystem);

        TreatmentRequest request =
                new TreatmentRequest(
                        "CLIENT-001",
                        "FACIAL_CARE",
                        60
                );

        TreatmentResult result =
                adapter.perform(request);

        assertTrue(result.successful());

        assertTrue(
                result.message().contains("procedure 101")
        );

        assertTrue(
                result.message().contains("CLIENT-001")
        );
    }
}
