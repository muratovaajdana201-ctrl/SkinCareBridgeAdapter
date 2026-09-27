import bridge.FacialCareSession;
import bridge.HydrationCareSession;
import bridge.SkinCareSession;
import bridge.TreatmentMethod;
import legacy.LegacySkinCareSystem;
import model.TreatmentRequest;
import model.TreatmentResult;
import selection.TreatmentMethodSelector;
import selection.TreatmentMethodType;

public class Main {

    public static void main(String[] args) {


        LegacySkinCareSystem legacySystem =
                new LegacySkinCareSystem();


        TreatmentMethodSelector selector =
                new TreatmentMethodSelector(legacySystem);


        TreatmentRequest request =
                new TreatmentRequest(
                        "CLIENT-001",
                        "FACIAL_CARE",
                        60
                );


        TreatmentMethod method =
                selector.select(TreatmentMethodType.LEGACY);

        SkinCareSession session =
                new FacialCareSession(method);


        TreatmentResult result =
                session.conduct(request);

        System.out.println("=== Skin Care Treatment System ===");
        System.out.println("Client: " + request.clientId());
        System.out.println("Service: " + request.serviceCode());
        System.out.println("Duration: "
                + request.durationMinutes() + " minutes");
        System.out.println("Successful: "
                + result.successful());
        System.out.println("Message: "
                + result.message());
    }
}
