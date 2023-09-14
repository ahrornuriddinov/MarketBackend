package uz.market.marketapplicationdemo.config.utilsSecurity;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public final class SecurityUtils {
    public SecurityUtils() {
    }
    public static Optional<String> getCurrentUsername(){
        SecurityContext context = SecurityContextHolder.getContext();
        return Optional.ofNullable(context.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails){
                        UserDetails principal = (UserDetails) authentication.getPrincipal();
                        return principal.getUsername();
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;

                });
    }
}
