package com.example.todoappfirebase.ui.auth

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todoappfirebase.data.Response
import com.example.todoappfirebase.ui.components.CustomButton
import com.example.todoappfirebase.ui.components.CustomTextField
import com.example.todoappfirebase.ui.navigation.Routes
// Importar as novas cores que serão definidas em Color.kt
import com.example.todoappfirebase.ui.theme.BackgroundPrimaryLight
import com.example.todoappfirebase.ui.theme.PrimaryAccent
import com.example.todoappfirebase.ui.theme.TextOnBackgroundDark
import com.example.todoappfirebase.ui.theme.TextOnSurfaceVariantDark


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val authState = viewModel.authState.collectAsState()
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Efeito colateral para observar mudanças no estado de autenticação
    LaunchedEffect(authState.value) {
        when (val state = authState.value) {
            is Response.Success -> {
                // Navega para a tela Home e remove a tela de Login do back stack
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Login.route) { inclusive = true }
                }
            }
            is Response.Error -> {
                // Exibe uma mensagem de erro em um Toast
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            // Não faz nada em outros estados (Loading, null)
            else -> Unit
        }
    }

    // Estrutura principal da tela de login
    Surface(
        modifier = Modifier.fillMaxSize(),
        // Usando uma cor de fundo mais suave e moderna para o Surface
        color = BackgroundPrimaryLight // Nova cor de fundo
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp), // Ajuste de padding
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título da tela de login
            Text(
                text = "Bem-vindo de volta!", // Título mais acolhedor
                style = MaterialTheme.typography.headlineLarge, // Fonte um pouco maior
                fontWeight = FontWeight.Bold,
                color = TextOnBackgroundDark // Nova cor de texto principal
            )

            Spacer(modifier = Modifier.height(8.dp)) // Espaçamento menor
            Text(
                text = "Entre na sua conta para continuar", // Subtítulo
                style = MaterialTheme.typography.bodyLarge,
                color = TextOnSurfaceVariantDark // Nova cor de texto secundário
            )

            Spacer(modifier = Modifier.height(32.dp)) // Espaçamento maior entre o título e os campos

            // Campo de email personalizado
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Seu Email", // Label mais descritiva
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth() // Garantir que o campo ocupe a largura total
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de senha personalizado
            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = "Sua Senha", // Label mais descritiva
                isPassword = true,
                modifier = Modifier.fillMaxWidth() // Garantir que o campo ocupe a largura total
            )

            Spacer(modifier = Modifier.height(32.dp)) // Espaçamento maior antes do botão

            // Botão de login personalizado
            CustomButton(
                text = if (authState.value is Response.Loading) "Entrando..." else "Entrar Agora", // Texto dinâmico no botão
                onClick = { viewModel.login(email, password) },
                isLoading = authState.value is Response.Loading,
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                modifier = Modifier.fillMaxWidth() // Garantir que o botão ocupe a largura total
            )

            Spacer(modifier = Modifier.height(24.dp)) // Espaçamento maior antes do link de cadastro

            // Seção para cadastro de nova conta
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Não tem uma conta? ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextOnSurfaceVariantDark // Nova cor de texto secundário
                )
                TextButton(
                    onClick = {
                        navController.navigate(Routes.SignUp.route)
                    },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = PrimaryAccent // Nova cor para o texto do botão
                    )
                ) {
                    Text(
                        text = "Crie uma!", // Texto mais convidativo
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium // Aplicar estilo de texto para consistência
                    )
                }
            }
        }
    }
}