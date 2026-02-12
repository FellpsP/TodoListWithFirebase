package com.example.todoappfirebase.ui.task

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todoappfirebase.ui.components.CustomTextField

/**
 * Componente Composable que exibe um diálogo para o usuário adicionar uma nova tarefa.
 * Oferece campos para inserir o título e a descrição da tarefa,
 * juntamente com ações para confirmar a adição ou cancelar o diálogo.
 *
 * @param onDismiss Callback a ser invocado quando o diálogo deve ser fechado.
 * @param onConfirm Callback a ser invocado quando a tarefa é confirmada, fornecendo o título e a descrição.
 */
@Composable
fun AddTaskDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    // Estado para controlar se a mensagem de erro do título deve ser exibida
    var showTitleError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Criar Nova Tarefa", // Título claro para o diálogo
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface // Garante boa visibilidade do título
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth() // Coluna ocupa toda a largura disponível
            ) {
                CustomTextField(
                    value = title,
                    onValueChange = {
                        title = it
                        // Esconde o erro assim que o usuário começa a digitar novamente
                        if (showTitleError && it.isNotBlank()) {
                            showTitleError = false
                        }
                    },
                    label = "Título da Tarefa" // Rótulo descritivo para o campo de título
                )

                // Exibe a mensagem de erro do título se showTitleError for verdadeiro e o título estiver em branco
                if (showTitleError && title.isBlank()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "O título da tarefa não pode estar vazio.", // Mensagem de erro amigável
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error // Cor de erro do tema
                    )
                }

                Spacer(modifier = Modifier.height(12.dp)) // Espaçamento entre os campos de texto

                CustomTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = "Descrição (Opcional)" // Rótulo para o campo de descrição
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        // Confirma a tarefa se o título não estiver em branco
                        onConfirm(title.trim(), description.trim())
                    } else {
                        // Se o título estiver vazio, define showTitleError como true para exibir a mensagem
                        showTitleError = true
                    }
                },
                enabled = title.isNotBlank(), // O botão é habilitado apenas se o título não estiver em branco
                shape = RoundedCornerShape(8.dp), // Cantos arredondados para o botão
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Cor de fundo do botão de confirmação
                    contentColor = MaterialTheme.colorScheme.onPrimary // Cor do texto/conteúdo
                )
            ) {
                Text(text = "Adicionar") // Texto do botão de confirmação
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss, // Ação de cancelar o diálogo
                shape = RoundedCornerShape(8.dp), // Cantos arredondados para o botão
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant // Cor do texto do botão de cancelar
                )
            ) {
                Text(text = "Cancelar") // Texto do botão de cancelar
            }
        },
        shape = RoundedCornerShape(16.dp), // Cantos arredondados para o diálogo
        containerColor = MaterialTheme.colorScheme.surface // Cor de fundo do corpo do diálogo
    )
}
