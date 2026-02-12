package com.example.todoappfirebase.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.todoappfirebase.data.model.Task

/**
 * TaskItem corrigido com checkbox funcionando
 *
 * Este componente Composable exibe uma única tarefa na lista,
 * permitindo ao usuário marcar/desmarcar a conclusão e deletá-la.
 * O design foi ajustado para se integrar à nova paleta de cores e ter um visual mais limpo.
 *
 * Mudanças principais:
 * 1. Checkbox agora está sincronizado corretamente com task.isCompleted
 * 2. UI mais limpa e moderna
 * 3. Melhor espaçamento e visual
 */
@Composable
fun TaskItem(
    task: Task,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp), // Padding vertical leve para separação entre os cards
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // Elevação ligeiramente maior para destaque sutil
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Usa a cor de superfície do tema para o fundo do card
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp) // Padding interno dentro do Card para o conteúdo
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Checkbox para marcar/desmarcar a tarefa como concluída
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { isChecked ->
                    onCheckedChange(isChecked) // Propaga a mudança de estado para o ViewModel
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary, // Cor principal do tema quando marcado
                    uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant // Cor secundária para o estado desmarcado
                )
            )

            Spacer(modifier = Modifier.width(12.dp)) // Espaçamento horizontal entre o checkbox e o texto da tarefa

            // Conteúdo da tarefa (título e descrição)
            Column(
                modifier = Modifier.weight(1f) // Ocupa o espaço restante disponível
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (task.isCompleted)
                        MaterialTheme.colorScheme.onSurfaceVariant // Cor mais suave se a tarefa estiver concluída
                    else
                        MaterialTheme.colorScheme.onSurface, // Cor padrão para tarefas não concluídas
                    textDecoration = if (task.isCompleted)
                        TextDecoration.LineThrough // Adiciona um risco no texto se a tarefa estiver concluída
                    else
                        null
                )

                if (task.description.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp)) // Pequeno espaçamento vertical entre título e descrição
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant, // Cor secundária para a descrição
                        textDecoration = if (task.isCompleted)
                            TextDecoration.LineThrough // Adiciona um risco no texto se a tarefa estiver concluída
                        else
                            null
                    )
                }
            }

            // Botão de deletar tarefa
            IconButton(
                onClick = onDelete, // Ação de deletar a tarefa
                modifier = Modifier.size(44.dp) // Aumenta o tamanho da área de toque do botão para melhor usabilidade
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Deletar tarefa",
                    tint = MaterialTheme.colorScheme.error // Usa a cor de erro do tema para o ícone de deletar
                )
            }
        }
    }
}