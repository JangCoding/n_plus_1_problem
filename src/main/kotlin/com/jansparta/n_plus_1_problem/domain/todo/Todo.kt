package com.jansparta.n_plus_1_problem.domain.todo

import com.jansparta.n_plus_1_problem.domain.comment.Comment
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "todo")
class Todo(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    var id: Long? = null,

    var contents: String,
    val date: LocalDate = LocalDate.now(),
    var isComplete: Boolean = false,

    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER)
    val comments: MutableList<Comment> = mutableListOf()
)