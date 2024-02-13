package com.jansparta.n_plus_1_problem.domain.comment
import com.jansparta.n_plus_1_problem.domain.todo.Todo
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "todo_id")
    val todo: Todo,
    val contents: String
)