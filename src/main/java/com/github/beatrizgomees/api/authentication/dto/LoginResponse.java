package com.github.beatrizgomees.api.authentication.dto;

public record LoginResponse(String acessToken, Long expiresIn) {
}
