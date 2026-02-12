package com.example.todoappfirebase.ui.theme

import androidx.compose.ui.graphics.Color

// ===========================================
// Paleta Principal (Inspirada em Teal/Aqua)
// ===========================================

// Cores primárias para o tema CLARO
// Antigos Purple80, PurpleGrey80, Pink80, Purple40, PurpleGrey40, Pink40 serão substituídos
val PrimaryLight = Color(0xFF00796B)   // Um verde-azulado mais escuro para o primário
val OnPrimaryLight = Color(0xFFFFFFFF)  // Texto sobre o primário
val PrimaryContainerLight = Color(0xFF66BB6A) // Um verde mais claro para containers
val OnPrimaryContainerLight = Color(0xFF002F26) // Texto sobre o container primário

val SecondaryLight = Color(0xFF00838F) // Um azul-ciano vibrante para secundário
val OnSecondaryLight = Color(0xFFFFFFFF) // Texto sobre o secundário
val SecondaryContainerLight = Color(0xFF80DEEA) // Um ciano mais claro
val OnSecondaryContainerLight = Color(0xFF00373B) // Texto sobre o container secundário

val TertiaryLight = Color(0xFF33691E) // Um verde mais escuro para terciário
val OnTertiaryLight = Color(0xFFFFFFFF)
val TertiaryContainerLight = Color(0xFF9CCC65) // Um verde claro
val OnTertiaryContainerLight = Color(0xFF143000)

val BackgroundLight = Color(0xFFF0FDFE) // Fundo muito claro, quase branco-azulado
val OnBackgroundLight = Color(0xFF191C1C) // Texto principal sobre o fundo
val SurfaceLight = Color(0xFFF8FDFD) // Superfícies gerais, um pouco diferente do background
val OnSurfaceLight = Color(0xFF191C1C) // Texto principal sobre a superfície
val SurfaceVariantLight = Color(0xFFE0E3E3) // Variantes de superfície
val OnSurfaceVariantLight = Color(0xFF404848) // Texto secundário sobre a superfície

val ErrorLight = Color(0xFFBA1A1A)
val OnErrorLight = Color(0xFFFFFFFF)
val ErrorContainerLight = Color(0xFFFFDAD6)
val OnErrorContainerLight = Color(0xFF410002)


// Cores primárias para o tema ESCURO
val PrimaryDark = Color(0xFF4DB6AC) // Um verde-azulado claro para o primário
val OnPrimaryDark = Color(0xFF003731)
val PrimaryContainerDark = Color(0xFF005047)
val OnPrimaryContainerDark = Color(0xFF6FE9D7)

val SecondaryDark = Color(0xFF4DD0E1) // Um ciano claro
val OnSecondaryDark = Color(0xFF00363C)
val SecondaryContainerDark = Color(0xFF004F58)
val OnSecondaryContainerDark = Color(0xFF6EE8F8)

val TertiaryDark = Color(0xFF9CCC65) // Um verde claro
val OnTertiaryDark = Color(0xFF1A3700)
val TertiaryContainerDark = Color(0xFF285000)
val OnTertiaryContainerDark = Color(0xFFB8EE80)

val BackgroundDark = Color(0xFF191C1C) // Fundo escuro
val OnBackgroundDark = Color(0xFFE0E3E3) // Texto principal sobre o fundo escuro
val SurfaceDark = Color(0xFF191C1C) // Superfícies escuras (pode ser o mesmo do background)
val OnSurfaceDark = Color(0xFFE0E3E3) // Texto principal sobre a superfície escura
val SurfaceVariantDark = Color(0xFF404848) // Variantes de superfície escura
val OnSurfaceVariantDark = Color(0xFFBFC8C8) // Texto secundário sobre a superfície escura

val ErrorDark = Color(0xFFFFB4AB)
val OnErrorDark = Color(0xFF690005)
val ErrorContainerDark = Color(0xFF93000A)
val OnErrorContainerDark = Color(0xFFFFDAD6)

// Cores específicas que podem ser usadas fora do MaterialTheme diretamente,
// para pontos de destaque ou compatibilidade.
// OBS: No Compose Material 3, o ideal é usar as cores do MaterialTheme.colorScheme,
// mas manter algumas cores diretas pode ser útil para componentes customizados
// que não sigam o tema completamente ou para depuração.

val PrimaryAccent = Color(0xFF4DB6AC) // Cor de destaque, pode ser igual ao PrimaryDark para consistência
val TextOnBackgroundDark = Color(0xFF191C1C) // Cor para textos escuros em fundos claros
val BackgroundPrimaryLight = Color(0xFFF0FDFE) // Fundo primário claro (já usado na LoginScreen)
val TextOnSurfaceVariantDark = Color(0xFF404848) // Cor para textos mais sutis em fundos claros
