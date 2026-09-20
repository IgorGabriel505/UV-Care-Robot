<div align="center">

# 🤖 UV-Care Robot

### Aplicativo Android para monitoramento e controle de um sistema de desinfecção UV

<p>
  <img src="https://img.shields.io/badge/Status-Protótipo%20Concluído-2ea44f?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Projeto-FETIN-7B2CBF?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Plataforma-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" />
</p>

<p>
  <a href="https://github.com/IgorGabriel505/UV-Care-Robot/releases/latest">
    <img src="https://img.shields.io/badge/⬇️%20Baixar%20APK-181717?style=for-the-badge&logo=android&logoColor=white" />
  </a>

  <a href="https://github.com/IgorGabriel505">
    <img src="https://img.shields.io/badge/GitHub-IgorGabriel505-181717?style=for-the-badge&logo=github&logoColor=white" />
  </a>

  <a href="https://www.linkedin.com/in/igor-gabriel-porto-vidal/">
    <img src="https://img.shields.io/badge/LinkedIn-Igor%20Gabriel-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" />
  </a>
</p>

</div>

---

## 📖 Sobre o projeto

O **UV-Care Robot** é um aplicativo Android desenvolvido em **Java** como protótipo demonstrativo para apresentação na **FETIN**.

A aplicação representa uma interface de monitoramento e controle para um sistema de desinfecção utilizando luz UV, permitindo ao usuário visualizar informações relacionadas ao estado do robô, executar comandos pela interface e acompanhar missões.

O objetivo do projeto foi demonstrar de maneira visual e interativa como um aplicativo Android pode funcionar como interface de operação de um sistema robótico.

> O aplicativo possui caráter demonstrativo. As funções apresentadas representam os fluxos e controles planejados para o sistema UV-Care Robot.

---

## 🎯 Objetivo

O projeto foi desenvolvido para apresentar uma solução capaz de centralizar a interação entre o usuário e o sistema UV-Care Robot.

Através do aplicativo é possível demonstrar:

* autenticação de usuários;
* monitoramento do estado do robô;
* visualização da bateria;
* indicação de localização;
* estado do sistema UV;
* estado de conexão;
* ativação do robô;
* parada segura;
* gerenciamento e visualização de missões;
* navegação entre diferentes áreas do sistema.

---

## 🎥 Demonstração

<div align="center">

![Demonstração UV-Care Robot](docs/demo/uv-care-demo.gif)

</div>

> Caso o GIF ainda não tenha sido adicionado, coloque o arquivo em `docs/demo/uv-care-demo.gif`.

---

## 📱 Interface do aplicativo

### 🔐 Login

<div align="center">

<img src="docs/screenshots/01-login.png" width="280"/>

</div>

Tela responsável pela autenticação do usuário através do **Firebase Authentication**, incluindo a opção de manter a sessão salva.

---

### 🤖 Painel principal

<div align="center">

<img src="docs/screenshots/02-dashboard.png" width="280"/>

</div>

O painel concentra as principais informações do sistema e os controles disponíveis durante a demonstração.

Entre as informações apresentadas estão:

* status do robô;
* nível de bateria;
* localização;
* estado do sistema UV;
* estado da conexão.

---

### ☰ Menu lateral

<div align="center">

<img src="docs/screenshots/03-menu-lateral.png" width="280"/>

</div>

O menu lateral permite navegar rapidamente entre as principais áreas do aplicativo.

---

### 📋 Missões

<div align="center">

<img src="docs/screenshots/04-missoes.png" width="280"/>

</div>

Tela destinada à visualização e gerenciamento das missões apresentadas durante a demonstração do sistema.

---

### ⚙️ Configurações

<div align="center">

<img src="docs/screenshots/05-configuracoes.png" width="280"/>

</div>

Área destinada às configurações da aplicação e gerenciamento da sessão do usuário.

---

## ⚙️ Funcionalidades

| Funcionalidade                       | Status |
| ------------------------------------ | :----: |
| 🔐 Login com Firebase Authentication |    ✅   |
| 💾 Lembrar login                     |    ✅   |
| 🤖 Painel de monitoramento           |    ✅   |
| 🔌 Ativação do robô pela interface   |    ✅   |
| 🛑 Parada segura                     |    ✅   |
| 🔋 Visualização da bateria           |    ✅   |
| 📍 Visualização da localização       |    ✅   |
| ☀️ Status do sistema UV              |    ✅   |
| 📡 Status de conexão                 |    ✅   |
| 📋 Tela de missões                   |    ✅   |
| ☰ Menu lateral                       |    ✅   |
| ⚙️ Configurações                     |    ✅   |
| 🚪 Logout                            |    ✅   |

---

## 🧪 Conta para demonstração

Para facilitar a avaliação do aplicativo, foi criada uma conta exclusivamente para demonstração:

```text
E-mail: teste@gmail.com
Senha: 123456
```

> A conta é utilizada somente para permitir o acesso às telas e funcionalidades demonstrativas do projeto.

---

## 🚀 Tecnologias utilizadas

### Linguagem e plataforma

<p>
  <img src="https://skillicons.dev/icons?i=java,androidstudio" />
  <img width="48" height="48" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/xml/xml-original.svg" />
</p>

**Java** · **Android Studio** · **XML**

### Autenticação

<p>
  <img src="https://skillicons.dev/icons?i=firebase" />
</p>

**Firebase Authentication**

### Versionamento e desenvolvimento

<p>
  <img src="https://skillicons.dev/icons?i=git,github,vscode" />
</p>

**Git** · **GitHub** · **Visual Studio Code**

---

## 🧩 Estrutura da aplicação

```text
Tela_Login
     │
     │ Firebase Authentication
     ▼
MainActivity
     │
     ├──────────────► Painel principal
     │
     ├──────────────► Controles
     │
     ├──────────────► Monitoramento
     │
     ├──────────────► Tela_Missoes
     │
     └──────────────► Tela_Configuracoes
                            │
                            ▼
                          Logout
```

### Principais classes

```text
Tela_Login.java
└── Autenticação e gerenciamento inicial da sessão

MainActivity.java
└── Painel principal, status e controles

Tela_Missoes.java
└── Interface relacionada às missões

Tela_Configuracoes.java
└── Configurações e logout
```

---

## 📂 Estrutura do repositório

```text
UV-Care-Robot/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/uv_carerobot/
│   │       │       ├── Tela_Login.java
│   │       │       ├── MainActivity.java
│   │       │       ├── Tela_Missoes.java
│   │       │       └── Tela_Configuracoes.java
│   │       │
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   ├── layout/
│   │       │   ├── menu/
│   │       │   ├── mipmap/
│   │       │   └── values/
│   │       │
│   │       └── AndroidManifest.xml
│   │
│   └── build.gradle.kts
│
├── docs/
│   ├── screenshots/
│   │   ├── 01-login.png
│   │   ├── 02-dashboard.png
│   │   ├── 03-menu-lateral.png
│   │   ├── 04-missoes.png
│   │   └── 05-configuracoes.png
│   │
│   └── demo/
│       └── uv-care-demo.gif
│
├── gradle/
├── .gitignore
├── LICENSE
├── README.md
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
├── gradlew
└── gradlew.bat
```

---

## ▶️ Executando o projeto

### Pré-requisitos

Para abrir o projeto pelo código-fonte:

* Android Studio;
* JDK compatível com o projeto;
* Android SDK;
* dispositivo Android ou emulador;
* configuração do Firebase quando necessária.

### Clone o repositório

```bash
git clone https://github.com/IgorGabriel505/UV-Care-Robot.git
```

Abra a pasta clonada utilizando o **Android Studio**.

Aguarde a sincronização do Gradle e execute o aplicativo em um dispositivo Android ou emulador.

---

## 📥 Testar sem abrir o código

Para facilitar a demonstração, uma versão compilada do aplicativo pode ser disponibilizada através do **GitHub Releases**.

<p>
  <a href="https://github.com/IgorGabriel505/UV-Care-Robot/releases/latest">
    <img src="https://img.shields.io/badge/⬇️%20Baixar%20versão%20mais%20recente-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" />
  </a>
</p>

Após instalar o APK:

```text
E-mail: teste@gmail.com
Senha: 123456
```

---

## 🏫 FETIN

O UV-Care Robot foi desenvolvido com foco em **demonstração durante a FETIN**, permitindo apresentar de maneira prática a experiência de interação entre o usuário e a proposta do sistema robótico.

O aplicativo funciona como a camada visual do projeto, reunindo informações, controles e navegação em uma interface Android desenvolvida especificamente para a apresentação.

---

## 📌 Status do projeto

<p>
  <img src="https://img.shields.io/badge/STATUS-PROTÓTIPO%20CONCLUÍDO-2ea44f?style=for-the-badge" />
</p>

O aplicativo atingiu o escopo definido para sua utilização como **protótipo demonstrativo na FETIN**.

O objetivo deste repositório é preservar o código-fonte, documentar a solução desenvolvida e permitir que outras pessoas conheçam e testem a aplicação.

---

## 👨‍💻 Autor

### Igor Gabriel

Estudante de **Engenharia de Software no INATEL** e Técnico em **Desenvolvimento de Sistemas pelo SENAI**, com foco em desenvolvimento de software e interesse profissional em **Back-end Java**.

<p>
  <a href="https://github.com/IgorGabriel505">
    <img src="https://img.shields.io/badge/GitHub-IgorGabriel505-181717?style=for-the-badge&logo=github&logoColor=white" />
  </a>

  <a href="https://www.linkedin.com/in/igor-gabriel-porto-vidal/">
    <img src="https://img.shields.io/badge/LinkedIn-Igor%20Gabriel-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" />
  </a>
</p>

---

## 📄 Licença

Este projeto está disponibilizado sob a **MIT License**.

Consulte o arquivo [`LICENSE`](LICENSE) para mais informações.

---

<div align="center">

### 🤖 UV-Care Robot

**Java • Android • Firebase • XML**

Desenvolvido para demonstração na FETIN.

</div>
