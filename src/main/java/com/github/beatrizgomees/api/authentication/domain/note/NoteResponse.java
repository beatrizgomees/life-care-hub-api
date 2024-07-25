package com.github.beatrizgomees.api.authentication.domain.note;


import com.github.beatrizgomees.api.authentication.domain.Doctor.Doctor;
import com.github.beatrizgomees.api.authentication.domain.todoList.TodoList;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record NoteResponse (UUID id, String title, String description, Doctor doctor, LocalDateTime dateConsult, LocalDateTime createdAt, List<TodoList> todoList){
}
