package kinggod.sayhelp.server;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // SMS 전송 서비스 API
    @Bean
    public DefaultMessageService messageService(@Value("${API-KEY}") String apiKey,
                                                @Value("${API-SECRET-KEY}") String apiSecretKey) {
        return NurigoApp.INSTANCE.initialize(apiKey,
                apiSecretKey,
                "https://api.coolsms.co.kr");
    }

}