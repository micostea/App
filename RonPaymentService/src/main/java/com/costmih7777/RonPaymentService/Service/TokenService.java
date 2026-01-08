package com.costmih7777.RonPaymentService.Service;

import com.costmih7777.RonPaymentService.DTO.TokenResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class TokenService {

    private String cachedToken;

    private String fetchNewTokenFromIng() {
        // apel HTTP către ING pentru token
        return ("mocked-token");
    }


}
