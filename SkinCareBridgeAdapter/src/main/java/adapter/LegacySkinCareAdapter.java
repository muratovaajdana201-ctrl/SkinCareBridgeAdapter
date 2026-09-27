package adapter;

import bridge.TreatmentMethod;
import legacy.LegacyResult;
import legacy.LegacySkinCareSystem;
import model.TreatmentRequest;
import model.TreatmentResult;
import exception.TreatmentException;

public class LegacySkinCareAdapter implements TreatmentMethod {

    private final LegacySkinCareSystem legacySystem;

    public LegacySkinCareAdapter(LegacySkinCareSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public TreatmentResult perform(TreatmentRequest request) {

        int procedureCode = mapServiceCode(request.serviceCode());

        LegacyResult legacyResult = legacySystem.execute(
                request.clientId(),
                procedureCode,
                request.durationMinutes()
        );

        if (!legacyResult.isSuccess()) {
            return new TreatmentResult(
                    false,
                    legacyResult.getDetails()
            );
        }

        return new TreatmentResult(
                true,
                legacyResult.getDetails()
        );
    }

    private int mapServiceCode(String serviceCode) {

        return switch (serviceCode) {
            case "FACIAL_CARE" -> 101;
            case "HYDRATION_CARE" -> 202;
            default -> throw new TreatmentException(
                    "Unknown service code: " + serviceCode
            );
        };
    }
}
