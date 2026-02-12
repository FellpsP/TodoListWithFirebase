package com.example.todoappfirebase.data

/** Gemini início
 *
 * Prompt: Aqui é muito importante, faça uma sealed class genérica chamada Response que irá gerenciar
 * todos os estados das telas, sendo: Loading, Success e Error.
 *
 */
sealed class Response<out T> {
    object Loading : Response<Nothing>()

    data class Success<out T>(
        val data: T
    ) : Response<T>()

    data class Error(
        val message: String
    ) : Response<Nothing>()
}
/** Gemini final */