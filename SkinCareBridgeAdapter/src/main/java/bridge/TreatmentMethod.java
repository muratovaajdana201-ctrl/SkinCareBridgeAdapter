package bridge;

import model.TreatmentRequest;
import model.TreatmentResult;

public interface TreatmentMethod {

    TreatmentResult perform(TreatmentRequest request);
}
