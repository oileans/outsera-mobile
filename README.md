🚀 Tecnologias

Java 17

Maven

Appium Java Client 8.6.0

Selenium Java 4.x

Cucumber Java 7.14.0

Cucumber JUnit

JUnit 4.12

Maven Surefire Plugin (para execução de testes)


⚙️ Pré-requisitos

Java JDK 17 instalado

Android SDK / Emulador (ou dispositivo real) configurado

Appium Server rodando em http://127.0.0.1:4723/wd/hub

Maven 3.x instalado

🔧 Instalação

Clone o repositório:

git clone https://github.com/seu-usuario/outsera-mobile.git
cd outsera-mobile

Configure suas variáveis de ambiente:

ANDROID_HOME apontando para o SDK Android

Garanta que o Appium Server esteja rodando:

🏃 Executando os Testes

Execute o comando Maven abaixo para rodar todos os cenários:

mvn clean test

Observação: O plugin Surefire está configurado para executar apenas as classes em src/test/java/runner/Test*.java.
