package com.example.todoappfirebase.data.model

import com.google.firebase.firestore.DocumentId

/** Gemini início
 *
 * Prompt: Crie para este projeto a classe de data chamada "Task".
 * Ela tera os seguintes campos: id, title, description, isCompleted e userId.
 * Adicione valores padrão para compatibilidade com Firestore.
 *
 */
data class Task(
    @DocumentId val id: String = "",
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val userId: String = ""
)
/** Gemini final */