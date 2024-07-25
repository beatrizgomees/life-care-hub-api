package com.github.beatrizgomees.api.authentication.domain.todoList;

import java.time.LocalDateTime;
import java.util.UUID;

public record TodoListResponse(UUID id,
                               String title,
                               String description,
                               LocalDateTime reminder,
                               boolean done){
}
