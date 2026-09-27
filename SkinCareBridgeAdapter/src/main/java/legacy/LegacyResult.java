package legacy;

public class LegacyResult {

    private final boolean success;
    private final String details;

    public LegacyResult(boolean success, String details) {
        this.success = success;
        this.details = details;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDetails() {
        return details;
    }
}
