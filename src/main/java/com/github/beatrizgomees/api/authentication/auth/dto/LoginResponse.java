package com.github.beatrizgomees.api.authentication.auth.dto;

public record LoginResponse(String acessToken, Long expiresIn) {
}
