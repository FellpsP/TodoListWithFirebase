package com.example.todoappfirebase.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoappfirebase.ui.auth.LoginScreen
import com.example.todoappfirebase.ui.auth.SignUpScreen
import com.example.todoappfirebase.ui.task.ListScreen

/** Gemini início
 *
 * Prompt: Crie um Composable AppNavHost que recebe um NavController e uma startDestination (padrão Routes.Login.route).
 * Configure o NavHost com as rotas definidas na sealed class Routes.
 * Defina os composables para LoginScreen, SignUpScreen e ListScreen, passando o navController para eles.
 *
 */
/**
 * Componente Composable principal que gerencia a navegação dentro do aplicativo.
 * Define as telas disponíveis e suas respectivas rotas, utilizando o [NavHost] do Jetpack Compose.
 *
 * @param navController O controlador de navegação usado para navegar entre as telas.
 * @param startDestination A rota inicial do aplicativo. Por padrão, é a tela de Login.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Routes.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Define a rota para a tela de Login, associando-a ao Composable LoginScreen
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }
        // Define a rota para a tela de Cadastro, associando-a ao Composable SignUpScreen
        composable(Routes.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        // Define a rota para a tela principal de listagem de tarefas (Home), associando-a ao Composable ListScreen
        composable(Routes.Home.route) {
            ListScreen(navController = navController)
        }
    }
}
/** Gemini final */