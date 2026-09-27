package bridge;

import model.TreatmentRequest;
import model.TreatmentResult;

public class ManualCareMethod implements TreatmentMethod {

    @Override
    public TreatmentResult perform(TreatmentRequest request) {
        return new TreatmentResult(
                true,
                "Manual care session prepared for service: "
                        + request.serviceCode()
        );
    }
}
