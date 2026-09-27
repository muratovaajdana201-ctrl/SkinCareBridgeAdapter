package selection;

import adapter.LegacySkinCareAdapter;
import bridge.DeviceCareMethod;
import bridge.ManualCareMethod;
import bridge.TreatmentMethod;
import legacy.LegacySkinCareSystem;

public class TreatmentMethodSelector {

    private final LegacySkinCareSystem legacySystem;

    public TreatmentMethodSelector(
            LegacySkinCareSystem legacySystem
    ) {
        this.legacySystem = legacySystem;
    }

    public TreatmentMethod select(
            TreatmentMethodType type
    ) {

        return switch (type) {

            case MANUAL ->
                    new ManualCareMethod();

            case DEVICE ->
                    new DeviceCareMethod();

            case LEGACY ->
                    new LegacySkinCareAdapter(
                            legacySystem
                    );
        };
    }
}
