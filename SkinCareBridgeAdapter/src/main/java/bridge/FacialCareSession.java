package bridge;

import model.TreatmentRequest;
import model.TreatmentResult;

public class FacialCareSession extends SkinCareSession {

    public FacialCareSession(TreatmentMethod treatmentMethod) {
        super(treatmentMethod);
    }

    @Override
    public TreatmentResult conduct(TreatmentRequest request) {
        return treatmentMethod.perform(request);
    }
}