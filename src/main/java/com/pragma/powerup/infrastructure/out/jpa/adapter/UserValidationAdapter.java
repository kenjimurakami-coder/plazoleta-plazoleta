/*package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.enums.Role;
import com.pragma.powerup.domain.spi.IUserValidationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserValidationAdapter implements IUserValidationPort {

    private final WebClient.Builder webClientBuilder;

    @Value("${usuarios.url}")
    private String usuariosUrl;

    @Override
    public Optional<Role> getUserRole(Long userId) {
        try {
            String url = String.format("%s/%d/role", usuariosUrl, userId);

            WebClient webClient = webClientBuilder.build();
            Role role = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(Role.class)
                    .block();

            return Optional.ofNullable(role);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Long getUserIdByUsername(String username) {
        // Lógica para llamar al microservicio de usuarios y obtener el ID
        // El endpoint podría ser algo como /api/v1/usuarios/id/{username}
        // Tendrías que implementar este endpoint en el microservicio de usuarios.
        return null;
    }

}
*/