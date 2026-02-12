package com.example.todoappfirebase.di

import com.example.todoappfirebase.data.repository.AuthRepository
import com.example.todoappfirebase.data.repository.AuthRepositoryImpl
import com.example.todoappfirebase.data.repository.TaskRepository
import com.example.todoappfirebase.data.repository.TaskRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Gemini início
 *
 * Prompt: De Di, o AppModule precisa ter as anotações com @Module e @InstallIn(SingletonComponent::class) para prover as dependências do Hilt.
 * Tendo também funções @Provides @Singleton para retornar instâncias de FirebaseAuth e FirebaseFirestore.
 * Finalize com @Provides @Singleton para retornar as interfaces AuthRepository e TaskRepository, recebendo suas implementações (AuthRepositoryImpl e TaskRepositoryImpl).
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    @Singleton
    fun provideTaskRepository(impl: TaskRepositoryImpl): TaskRepository = impl
}
/** Gemini final */