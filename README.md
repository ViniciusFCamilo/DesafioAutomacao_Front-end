# Desafio de Automação Front-end - Grocery CRUD
## ==== Sobre o Projeto ====
Esse projeto tem como objetivo testar uma aplicação web de cadastros de customers
## ==== Requisitos para rodar o projeto ====
- Deve possuir o Java 8+ JDK, e o Maven instalados
- Deve possuir as variaveis de ambiente do java e do maven configuradas
- Deve possuir o webdriver do navegador que deseja rodar o teste dentro do diretório raiz do projeto
  
  - A versão do webdriver deve ser a mesma versão do seu navegador
  - O projeto já está com o webdriver do Chrome versão 107 para Windows 64x
    
    - Caso deseje rodar em outra versão ou outro sistema operacional baixe o webdriver <a href='https://chromedriver.chromium.org/downloads'>clicando aqui</a>

### Configuração das variaveis
#### Criar variavel - Maven
- Nome da variavel = M2_HOME
- Valor da Variavel = caminho conde o maven foi instalado

Java
- Nome da variavel = CLASS_PATH
- Valor da Variavel = %JAVA_HOME%\lib\tools.jar;.;

#### Adicionar variaveis no path
- Selecionar path e clicar em editar
- Adicionar duas novas variavéis com os seguintes valores

    - Caminho onde o maven foi instalado\bin
    - %JAVA_HOME%\bin

- Clicar em ok

## ==== Como rodar o projeto ====
1. Abrir o projeto e esperar todas as dependencias serem baixadas.
2. Abrir o arquivo pom.xml e sincronizar as mudanças do maven (Atalho no IntelliJ: Ctrl + Shift + O)
3. Executar os testes pela classe RunDesafioTest que fica em src/test/java/runners
## ==== Visualizar resultado das execuções ====
Após rodar o projeto, será criado um diretório "\target\reports" dentro da raiz do projeto, com os relatórios de execução de cada Feature
## ==== Desafios ====
### Desafio 1:
Observação:
O script deve executar no browser Google Chrome
<br><br>
Passos:

1. Acessar a página https://www.grocerycrud.com/v1.x/demo/bootstrap_theme
2. Mudar o valor da combo Select version para “Bootstrap V4 Theme”
3. Clicar no botão Add Customer
4. Preencher os campos do formulário com as seguintes informações:


    Name: Teste Nome
    Last name: Ultimo Nome
    ContactFirstName: Primeiro Nome
    Phone: 48 9999-9999
    AddressLine1: Imigrante Meller, 1430
    AddressLine2: Apartamento 201
    City: Criciúma
    State: SC
    PostalCode: 88800-001
    Country: Brasil
    from Employeer: Fixter
    CreditLimit: 100
    Deleted: Deleted

5. Clicar no botão Save
6. Validar a mensagem “Your data has been successfully stored into the database. Edit
   Customer or Go back to list” através de uma asserção
7. Fechar o browser


### Desafio 2:
Observação:
O script deve executar no browser Google Chrome
<br><br>
Pré-condição:
Execute todos os passos do Desafio 1
<br><br>
Passos:
1. Clicar no link Go back to list
2. Clicar na coluna “Search Name” e digitar o conteúdo do Name (Teste Nome)
3. Clicar no checkbox do primeiro item listado
4. Clicar no botão Delete
5. Validar o texto “Are you sure that you want to delete this 1 item?” através de uma
   asserção para a popup que será apresentada
6. Clicar no botão Delete da popup, aparecerá uma mensagem dentro de um box verde na
   parte superior direito da tela. Adicione uma asserção na mensagem “Your data has been
   successfully deleted from the database.”
7. Fechar o browser
