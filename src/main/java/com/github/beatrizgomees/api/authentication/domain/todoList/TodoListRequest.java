package com.github.beatrizgomees.api.authentication.domain.todoList;

import java.time.LocalDateTime;
import java.util.UUID;

public record TodoListRequest (UUID id, String title, String description, boolean done, LocalDateTime reminder){
}
