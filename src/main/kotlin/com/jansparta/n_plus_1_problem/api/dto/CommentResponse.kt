package com.jansparta.n_plus_1_problem.api.dto

import com.jansparta.n_plus_1_problem.domain.comment.Comment

data class CommentResponse(
    val todoId : Long,
    val commentId : Long,
    val comment : String
){
    companion object {
        fun from(comment : Comment) = CommentResponse(
            todoId = comment.todo.id!!,
            commentId = comment.id!!,
            comment = comment.contents
        )
    }
}
