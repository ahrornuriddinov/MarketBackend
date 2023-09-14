package uz.market.marketapplicationdemo.config.utilsSecurity;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getCurrentUsername()
                .orElse("Bunday foydalanuvchi mavjud emas"));
    }
}
