# ✅ Gerenciador de Tarefas com Firebase e Jetpack Compose

Aplicativo Android nativo desenvolvido em **Kotlin** para gerenciamento de tarefas pessoais. Utiliza **Jetpack Compose** para construção de interface moderna e **Firebase** como backend, seguindo práticas modernas de desenvolvimento Android como injeção de dependência e arquitetura limpa.

## ✨ Funcionalidades

* **Autenticação de Usuários:**
    * Cadastro e login com e-mail e senha via Firebase Authentication.
    * Validação de dados de entrada e tratamento de erros.
* **Gerenciamento Completo de Tarefas:**
    * Criação de novas tarefas de forma rápida.
    * Listagem automática atualizada em tempo real.
    * Marcação de conclusão com seleção direta na lista.
    * Exclusão de tarefas indesejadas.
* **Interface Dinâmica:** UI construída com Compose, totalmente reativa e com atualizações visuais instantâneas conforme o estado do aplicativo muda.

## 🧱 Arquitetura do Projeto

A aplicação foi estruturada com base nos princípios de **Clean Architecture** e no padrão **MVVM**, assegurando separação de responsabilidades e facilitando testes e manutenção.

### 1. Padrão MVVM
* **View (UI):** Composta por elementos de interface construídos com Jetpack Compose. Responsável apenas por exibir dados e capturar interações do usuário.
* **ViewModel:** Gerencia os dados relacionados à UI, expondo estados observáveis (como `StateFlow`) para a View. Sobrevive a mudanças de configuração (como rotação de tela).
* **Model:** Representa as entidades de dados centrais da aplicação, como a estrutura de uma tarefa (`Task`).

### 2. Injeção de Dependência com Hilt
O **Hilt** é utilizado para gerenciar e fornecer dependências de forma automatizada.
* **Benefício:** Reduz o código boilerplate e melhora a testabilidade. Classes como ViewModels e Repositórios são injetadas onde necessário através de anotações como `@HiltViewModel` e `@Inject`.

### 3. Padrão de Repositório
Uma camada de repositório abstrai a fonte de dados.
* **Vantagem:** Isola a lógica de acesso aos dados. Se a fonte mudar (ex.: do Firestore para uma API REST), apenas o repositório precisa ser alterado, sem impactar a ViewModel ou a View.

### 4. Navegação
A navegação entre telas é realizada utilizando o componente **Navigation Compose**, dentro do conceito de aplicativo com uma única Activity.

## 🛠️ Stack Tecnológica

* **Linguagem:** Kotlin
* **UI Toolkit:** Jetpack Compose, Material Design 3
* **Injeção de Dependência:** Hilt
* **Backend como Serviço (BaaS):** Firebase (Authentication, Firestore)
* **Programação Assíncrona:** Coroutines e Flow

---

## 📲 Telas do Aplicativo

### Tela de Autenticação
Oferece uma experiência focada no usuário, com formulários para login e cadastro, incluindo feedbacks visuais para orientar em caso de erros.

### Tela Principal (Lista de Tarefas)
É o centro do aplicativo. O usuário pode visualizar todas as tarefas, adicionar novas, marcar como concluídas ou removê-las. Todas as alterações são refletidas imediatamente na interface e sincronizadas com o banco de dados.

---

## 📥 Como Executar o Projeto

1.  **Clonar o Repositório:**
    ```bash
    git clone https://github.com/FellpsP/TodoListWithFirebase.git
    ```
2.  **Abrir o Projeto:** Importe a pasta clonada no **Android Studio**.
3.  **Configurar o Firebase:**
    * Acesse o [Console do Firebase](https://console.firebase.google.com/) e crie um novo projeto.
    * Adicione um aplicativo Android ao seu projeto Firebase.
    * Baixe o arquivo de configuração `google-services.json`.
    * Copie o arquivo para o diretório `app/` dentro do projeto Android.
4.  **Executar:** Sincronize o projeto com o Gradle e execute-o em um emulador ou dispositivo físico.

---

**Repositório do Projeto:** [https://github.com/FellpsP/TodoListWithFirebase](https://github.com/FellpsP/TodoListWithFirebase)

*Documentação original adaptada para este repositório com ajuda do DeepSeek.*
