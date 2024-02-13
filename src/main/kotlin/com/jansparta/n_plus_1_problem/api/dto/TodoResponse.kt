package com.jansparta.n_plus_1_problem.api.dto

import com.jansparta.n_plus_1_problem.domain.todo.Todo

data class TodoResponse (
    val todoId: Long,
    val contents : String,
    val isComplete : Boolean,
    val comments : List<CommentResponse>
){
    companion object {
        fun from(todo : Todo) = TodoResponse(
            todoId =  todo.id!!,
            contents = todo.contents,
            isComplete = todo.isComplete,
            comments = emptyList()
        )
    }
}
