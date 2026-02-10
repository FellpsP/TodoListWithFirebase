package com.example.todoappfirebase.ui.auth

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todoappfirebase.data.Response
import com.example.todoappfirebase.ui.components.CustomButton
import com.example.todoappfirebase.ui.components.CustomTextField
import com.example.todoappfirebase.ui.navigation.Routes

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val authState = viewModel.authState.collectAsState()
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LaunchedEffect(authState.value) {
        when (val state = authState.value) {
            is Response.Success -> {
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Login.route) { inclusive = true }
                }
            }
            is Response.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Entre em sua conta",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = "Senha",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomButton(
                text = "Entrar",
                onClick = { viewModel.login(email, password) },
                isLoading = authState.value is Response.Loading,
                enabled = email.isNotEmpty() && password.isNotEmpty()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Não tem conta? ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                TextButton(onClick = {
                    navController.navigate(Routes.SignUp.route)
                }) {
                    Text(
                        text = "Cadastre-se",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}