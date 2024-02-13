package com.jansparta.n_plus_1_problem.domain.todo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

    // database 가 아닌 JPQL 로 처리하는 방법
    @Query("SELECT todo FROM Todo todo JOIN FETCH todo.comments")
    fun findAllWithFetchJoin(): List<Todo>
}