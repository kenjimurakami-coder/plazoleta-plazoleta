package com.pragma.powerup.infrastructure.out.feign.client;

import com.pragma.powerup.domain.enums.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "usuarios-service", url = "${usuarios.url}")
public interface UserValidationClient {

    @GetMapping("/api/v1/auth/role/{userId}")
    Optional<Role> getUserRole(@PathVariable("userId") Long userId);

    @GetMapping("/api/v1/user/id/{correo}")
    Long getUserIdByCorreo(@PathVariable("correo") String correo);
}