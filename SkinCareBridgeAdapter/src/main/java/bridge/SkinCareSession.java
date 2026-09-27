package bridge;

import model.TreatmentRequest;
import model.TreatmentResult;

public abstract class SkinCareSession {

    protected final TreatmentMethod treatmentMethod;

    protected SkinCareSession(TreatmentMethod treatmentMethod) {
        this.treatmentMethod = treatmentMethod;
    }

    public abstract TreatmentResult conduct(
            TreatmentRequest request
    );
}
