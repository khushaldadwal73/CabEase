package com.example.Cabeasebackend.Security;

import com.example.Cabeasebackend.Config.AdminJwtProperties;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Service
public class JwtTokenService {

    private static final String HMAC_ALGORITHM = "HmacSHA256";

    private final AdminJwtProperties adminJwtProperties;
    private final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
    private final Base64.Decoder decoder = Base64.getUrlDecoder();

    public JwtTokenService(AdminJwtProperties adminJwtProperties) {
        this.adminJwtProperties = adminJwtProperties;
    }

    public String generateAdminToken() {
        long issuedAt = Instant.now().getEpochSecond();
        long expiresAt = issuedAt + adminJwtProperties.getExpirationSeconds();

        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String payload = String.format(
                "{\"sub\":\"%s\",\"role\":\"ADMIN\",\"iat\":%d,\"exp\":%d}",
                escapeJson(adminJwtProperties.getUsername()),
                issuedAt,
                expiresAt
        );

        String unsignedToken = encode(header) + "." + encode(payload);
        return unsignedToken + "." + sign(unsignedToken);
    }

    public boolean isValidAdminToken(String token) {
        if (token == null || token.isBlank()) {
            return false;
        }

        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            return false;
        }

        String unsignedToken = parts[0] + "." + parts[1];
        if (!constantTimeEquals(sign(unsignedToken), parts[2])) {
            return false;
        }

        String payload = new String(decoder.decode(parts[1]), StandardCharsets.UTF_8);
        return payload.contains("\"role\":\"ADMIN\"")
                && payload.contains("\"sub\":\"" + escapeJson(adminJwtProperties.getUsername()) + "\"")
                && extractExpiration(payload) > Instant.now().getEpochSecond();
    }

    private String encode(String value) {
        return encoder.encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    private String sign(String value) {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(
                    adminJwtProperties.getSecret().getBytes(StandardCharsets.UTF_8),
                    HMAC_ALGORITHM
            );
            mac.init(keySpec);
            return encoder.encodeToString(mac.doFinal(value.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception exception) {
            throw new IllegalStateException("Unable to sign admin token", exception);
        }
    }

    private long extractExpiration(String payload) {
        String expKey = "\"exp\":";
        int start = payload.indexOf(expKey);
        if (start == -1) {
            return 0;
        }

        start += expKey.length();
        int end = start;
        while (end < payload.length() && Character.isDigit(payload.charAt(end))) {
            end++;
        }

        if (start == end) {
            return 0;
        }

        return Long.parseLong(payload.substring(start, end));
    }

    private boolean constantTimeEquals(String first, String second) {
        byte[] firstBytes = first.getBytes(StandardCharsets.UTF_8);
        byte[] secondBytes = second.getBytes(StandardCharsets.UTF_8);

        if (firstBytes.length != secondBytes.length) {
            return false;
        }

        int result = 0;
        for (int index = 0; index < firstBytes.length; index++) {
            result |= firstBytes[index] ^ secondBytes[index];
        }
        return result == 0;
    }

    private String escapeJson(String value) {
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
