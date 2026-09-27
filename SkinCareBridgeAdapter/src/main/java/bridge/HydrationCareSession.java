package bridge;

import model.TreatmentRequest;
import model.TreatmentResult;

public class HydrationCareSession extends SkinCareSession {

    public HydrationCareSession(TreatmentMethod treatmentMethod) {
        super(treatmentMethod);
    }

    @Override
    public TreatmentResult conduct(TreatmentRequest request) {
        return treatmentMethod.perform(request);
    }
}
