package com.jansparta.n_plus_1_problem.api

import com.jansparta.n_plus_1_problem.api.dto.CommentResponse
import com.jansparta.n_plus_1_problem.api.dto.TodoResponse
import com.jansparta.n_plus_1_problem.domain.comment.CommentRepository
import com.jansparta.n_plus_1_problem.domain.todo.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
) {

    @Transactional(readOnly = true)
    fun retrieveAllTodos(): List<TodoResponse> {
        return todoRepository.findAll()
            .map { TodoResponse.from(it) }
    }

    @Transactional(readOnly = true)
    fun retrieveAllComments(): List<CommentResponse> {
        return commentRepository.findAll()
            .mapNotNull { CommentResponse.from(it) }
    }
}