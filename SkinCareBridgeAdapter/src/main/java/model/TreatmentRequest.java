package model;

public record TreatmentRequest(
        String clientId,
        String serviceCode,
        int durationMinutes
) {
}