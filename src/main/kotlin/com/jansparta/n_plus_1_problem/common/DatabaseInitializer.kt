package com.jansparta.n_plus_1_problem.common

import com.jansparta.n_plus_1_problem.domain.comment.Comment
import com.jansparta.n_plus_1_problem.domain.comment.CommentRepository
import com.jansparta.n_plus_1_problem.domain.todo.Todo
import com.jansparta.n_plus_1_problem.domain.todo.TodoRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
) : ApplicationRunner { // run 할 때 insert 쿼리 날리도록 함
    override fun run(args: ApplicationArguments) {

        // localhost:8080/api/v1/todos 로 확인 가능
        val todo1 = todoRepository.save(Todo(contents = "할일1"))
        commentRepository.save(Comment(todo = todo1, contents = "제대로 하고있나?"))
        commentRepository.save(Comment(todo = todo1, contents = "안하고 있는것 같은데.."))
        commentRepository.save(Comment(todo = todo1, contents = "결국 못했다."))
        val todo2 = todoRepository.save(Todo(contents = "할일2"))
        commentRepository.save(Comment(todo = todo2, contents = "할일2 처리 완료"))
        val todo3 = todoRepository.save(Todo(contents = "할일3"))
        commentRepository.save(Comment(todo = todo3, contents = "할일3 처리 완료"))
        val todo4 = todoRepository.save(Todo(contents = "할일4"))
        commentRepository.save(Comment(todo = todo4, contents = "오늘 할수있을까..."))
        commentRepository.save(Comment(todo = todo4, contents = "성공!"))
    }
}