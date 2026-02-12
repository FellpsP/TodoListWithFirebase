package com.example.todoappfirebase.data.repository

import com.example.todoappfirebase.data.Response
import com.google.firebase.auth.FirebaseUser

/** Gemini início
 *
 * Prompt: Faça diligentemente a interface AuthRepository.
 * Com funções suspensas para login, cadastro, logout e uma propriedade para obter o usuário atual (currentUser).
 * As funções devem retornar a classe Response que servirá de auxilio.
 *
 */
interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Response<Boolean>

    suspend fun signUp(email: String, password: String): Response<Boolean>

    fun signOut()
}
/** Gemini final */