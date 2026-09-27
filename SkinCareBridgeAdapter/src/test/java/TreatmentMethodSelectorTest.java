import adapter.LegacySkinCareAdapter;
import bridge.DeviceCareMethod;
import bridge.ManualCareMethod;
import bridge.TreatmentMethod;
import legacy.LegacySkinCareSystem;
import org.junit.jupiter.api.Test;
import selection.TreatmentMethodSelector;
import selection.TreatmentMethodType;

import static org.junit.jupiter.api.Assertions.*;

class TreatmentMethodSelectorTest {

    @Test
    void selectorShouldReturnManualMethod() {

        LegacySkinCareSystem legacySystem =
                new LegacySkinCareSystem();

        TreatmentMethodSelector selector =
                new TreatmentMethodSelector(legacySystem);

        TreatmentMethod method =
                selector.select(
                        TreatmentMethodType.MANUAL
                );

        assertInstanceOf(
                ManualCareMethod.class,
                method
        );
    }

    @Test
    void selectorShouldReturnDeviceMethod() {

        LegacySkinCareSystem legacySystem =
                new LegacySkinCareSystem();

        TreatmentMethodSelector selector =
                new TreatmentMethodSelector(legacySystem);

        TreatmentMethod method =
                selector.select(
                        TreatmentMethodType.DEVICE
                );

        assertInstanceOf(
                DeviceCareMethod.class,
                method
        );
    }

    @Test
    void selectorShouldReturnAdapterForLegacy() {

        LegacySkinCareSystem legacySystem =
                new LegacySkinCareSystem();

        TreatmentMethodSelector selector =
                new TreatmentMethodSelector(legacySystem);

        TreatmentMethod method =
                selector.select(
                        TreatmentMethodType.LEGACY
                );

        assertInstanceOf(
                LegacySkinCareAdapter.class,
                method
        );
    }
}