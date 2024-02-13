package com.jansparta.n_plus_1_problem.domain.todo

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

    // database 가 아닌 JPQL 로 처리하는 방법
    @Query("SELECT todo FROM Todo todo JOIN FETCH todo.comments")
    fun findAllWithFetchJoin(): List<Todo>

    @EntityGraph(attributePaths = ["comments"]) // comments 와 연관관계가 있음을 알림. 같이 가져오라는 뜻
    @Query("SELECT todo FROM Todo todo") //  JOIN FETCH todo.comments 생략
    fun findAllWithEntityGraph(): List<Todo>
}