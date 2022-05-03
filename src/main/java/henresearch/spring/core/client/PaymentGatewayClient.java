package henresearch.spring.core.client;

import lombok.Data;

//misal class ini punyanya 3rd party liblary(payment gateway a)
//misal kita tidak bisa tambahkan apa apa di class ini

@Data
public class PaymentGatewayClient {
    private String endPoint;

    private String publicKey;

    private String privateKey;
}
