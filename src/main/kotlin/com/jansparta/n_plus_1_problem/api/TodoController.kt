package com.jansparta.n_plus_1_problem.api

import com.jansparta.n_plus_1_problem.api.dto.CommentResponse
import com.jansparta.n_plus_1_problem.api.dto.TodoResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(
    private val todoService: TodoService
) {
    // localhost:8080/api/v1/todos 로 swagger 없이 url로 확인 가능
    @GetMapping("/api/v1/todos")
    fun retrieveAllTodos(): List<TodoResponse> {
        return todoService.retrieveAllTodos()
    }

    @GetMapping("/api/v1/comments")
    fun retrieveAllComments(): List<CommentResponse> {
        return todoService.retrieveAllComments()
    }
}