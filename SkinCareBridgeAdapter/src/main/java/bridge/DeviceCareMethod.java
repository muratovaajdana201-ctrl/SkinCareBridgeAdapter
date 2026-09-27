package bridge;

import model.TreatmentRequest;
import model.TreatmentResult;

public class DeviceCareMethod implements TreatmentMethod {

    @Override
    public TreatmentResult perform(TreatmentRequest request) {
        return new TreatmentResult(
                true,
                "Device-assisted care session prepared for service: "
                        + request.serviceCode()
        );
    }
}
