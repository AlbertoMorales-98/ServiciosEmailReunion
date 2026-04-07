package Correos.api;

public record ApiResponse(
        int codigo,
        String status,
        String message
) {
}
