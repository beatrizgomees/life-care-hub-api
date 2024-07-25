package com.github.beatrizgomees.api.authentication.domain.note;

import com.github.beatrizgomees.api.authentication.domain.Doctor.DoctorDTO;
import com.github.beatrizgomees.api.authentication.domain.todoList.TodoListDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record NoteRequest (
        UUID id,
        String title,
        String description,
        DoctorDTO doctor,
        LocalDateTime dateConsult,
        LocalDateTime createdAt,
        List<TodoListDTO> todoList){
}
