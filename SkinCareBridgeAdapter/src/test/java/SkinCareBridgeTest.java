import bridge.FacialCareSession;
import bridge.HydrationCareSession;
import bridge.ManualCareMethod;
import bridge.DeviceCareMethod;
import bridge.SkinCareSession;
import bridge.TreatmentMethod;
import model.TreatmentRequest;
import model.TreatmentResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkinCareBridgeTest {

    @Test
    void facialCareShouldWorkWithManualMethod() {

        TreatmentMethod method =
                new ManualCareMethod();

        SkinCareSession session =
                new FacialCareSession(method);

        TreatmentRequest request =
                new TreatmentRequest(
                        "CLIENT-001",
                        "FACIAL_CARE",
                        60
                );

        TreatmentResult result =
                session.conduct(request);

        assertTrue(result.successful());

        assertTrue(
                result.message().contains("Manual care")
        );
    }

    @Test
    void hydrationCareShouldWorkWithDeviceMethod() {

        TreatmentMethod method =
                new DeviceCareMethod();

        SkinCareSession session =
                new HydrationCareSession(method);

        TreatmentRequest request =
                new TreatmentRequest(
                        "CLIENT-002",
                        "HYDRATION_CARE",
                        45
                );

        TreatmentResult result =
                session.conduct(request);

        assertTrue(result.successful());

        assertTrue(
                result.message().contains("Device-assisted")
        );
    }
}
