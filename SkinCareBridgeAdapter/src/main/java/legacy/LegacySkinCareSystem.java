package legacy;

public class LegacySkinCareSystem {

    public LegacyResult execute(
            String clientReference,
            int procedureCode,
            int durationMinutes
    ) {

        String details =
                "Legacy system executed procedure "
                        + procedureCode
                        + " for client "
                        + clientReference
                        + " for "
                        + durationMinutes
                        + " minutes.";

        return new LegacyResult(true, details);
    }
}
