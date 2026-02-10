package com.example.todoappfirebase.data.model

import com.google.firebase.firestore.DocumentId

/** Gemini início
 *
 * Prompt: Crie uma data class Task com id, title, description, isCompleted e userId. Adicione valores padrão para compatibilidade com Firestore.
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