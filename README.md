# 2a Unidade (nota 6)

## Aluno
Davi Fernandes Neves Costa

## Todas as Portas
ISP - 8080
DNS - 8081
EUREKA - 8761
VALIDACAO APLICAÇÃO B - 8181
PERFIL APLICACAO A - 8182
DFS APLICACAO A - 8281
DFS APLICACAO B - 8282
DFS APLICACAO C - 8283

## Como rodar o projeto
- Baixa a extensão **Spring Boot Dashboard** no VsCode
- Rode primeiro o **eureka-server-app-main**

![Screenshot from 2024-04-26 10-57-25](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/6d54054d-4a22-45a3-8fcd-d68ccad1ff29)

![Screenshot from 2024-04-26 10-59-10](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/8e54b85c-ff18-40f8-9b63-e51054b55cc5)

- Após ao eureka server estiver rodando, rode primeiro o arquivo com nome **aplicacao-a-validacao-app** e espere iniciar, depois o **aplicacao-b-perfil-app** e espere iniciar, e por ultimo **isp-server-app** e espera inicar.

![Screenshot from 2024-04-26 11-02-20](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/adee07c2-27cb-4420-8be3-aacce56257f5)

![Screenshot from 2024-04-26 11-02-34](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/6fef30c0-7f6b-4a87-a1c2-49b2768fa8d8)

![Screenshot from 2024-04-26 11-02-59](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/bf271cc0-883e-457d-8643-e134636ae6ec)

- Por último, e não menos importante, rode o arquivo **dns-server-app-main** e espere iniciar

![Screenshot from 2024-04-26 11-08-50](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/2d6179e6-10db-447b-bf64-2c4aeda695d8)

- Com todos os arquivos rodando, é possível testar ele!!!

## Como testar o Projeto
- Todas as solicitações seram feitas através do isp, que esta na porta 8080
- Para testar validação, terá que usar a porta http://localhost:8080/validate
- Para testar os perfis, terá que usar a porta http://localhost:8080/profile
- Todos perfis válidos
```
  public PerfilController() {
        perfis.put("sampio@gmail.com", "Aluno");
        perfis.put("exemplo@hotmail.com", "Professor");
        perfis.put("usuario123@yahoo.com", "Funcionário");
        perfis.put("jose@email.com", "Aluno");
        perfis.put("ronaldo@ucsal.edu.br", "Professor");
    }
```
- Todos emails válidos
```
    public ValidationController() {
        emailList.add("sampio@gmail.com");
        emailList.add("exemplo@hotmail.com");
        emailList.add("usuario123@yahoo.com");
        emailList.add("jose@email.com");
        emailList.add("ronaldo@ucsal.edu.br");
    }
```
  
![Screenshot from 2024-04-26 11-30-27](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/b45a4d71-8076-457b-99bc-5d242af56179)

![Screenshot from 2024-04-26 11-31-36](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/27e35221-c3f8-47bf-aaf6-70b665559e2f)

![Screenshot from 2024-04-26 11-33-03](https://github.com/davimgfx/SD-Projeto-Unidade-1/assets/118557337/e57abfbd-6027-42f7-b037-1d24400ba236)


## Orientações

• Deverá ser feito em equipe de no máximo três alunos
• O trabalho deverá ser entregue:
o Em repositório público (Github, Gitlab e etc)
o Em arquivo zip no classroom seguindo o formato
SD_T1_Entrega_TrabalhoUn1_<PrimeiroNomeAluno1_PrimeiroNomeAluno2_
PrimeiroNomeAluno3>.zip
▪ Ex: SD_T1_Entrega_TrabalhoUn1_<Everton_Elias_Elton>.zip
• No README do projeto deverá constar o nome completo dos três alunos

## Como as aplicações deverão ser construídas
• As aplicações deverão ser desenvolvidas utilizando as seguintes tecnologias
o Java 17+
o SpringBoot
o Maven 3.9.6+
• A aplicação deverá ter um endpoint REST funcional para que a solução seja testada
• Deverão ser fornecidos exemplos para teste
• Toda a comunicação entre as aplicações deverá ser feita por API REST
• O acesso deverá ser apenas pela aplicação principal, todo o processo de descoberta e
acesso as outras apps deve ficar transparente para o usuário final
## O Que Será Avaliado
• Atendimento aos critérios do trabalho
• Organização do código
• Documentação do projeto, incluindo explicação e roteiro sobre como executá-lo
• Tratamento de exceções
• Será verificado se todos os membros da equipe fizeram commits. Caso não conste nenhum
commit do aluno, ele poderá ter a nota zerada.
• Não se preocupem em subir commits quebrados. É importante que eu veja o fluxo de trabalho
e não apenas um commit único com o trabalho pronto.
• Implementar testes unitários vale pontuação extra
• Implementar outras formas de comunicação como websocket ou rpc vale um ponto extra.
##  Objetivo
Implementar serviço de validação de usuários e obtenção de perfis. O principal objetivo deste projeto é implementar um serviço de DNS e descoberta de aplicações. Sempre que o usuário requisitar via
API um recurso ao servidor, ele deve resolver a url, acessar o serviço e retornar ao usuário o resultado
da operação.

## DETALHAMENTO

Cenário de exemplo

• Validação do e-mail
1. Do insomnia, envio requisição POST para o endpoint validacao.<seuservidor>:8080
enviando o payload: {e-mail: ”everton@pro.ucsal.br}.
1. O servidor ISP irá receber a requisição, consultar o servidor DNS para obter IP de acesso.
2. Servidor DNS recebe a requisição, consulta servidor Eureka obtendo a lista de aplicações
ativas
1. Consulta o endereço contido na requisição recebida do servidor ISP em caso encontre,
retorna para servidor ISP o IP e porta.
1. Servidor ISP faz a chamada a aplicação com IP e porta e retorna resultado ao usuário
• Obtenção de dados de perfil
1. Do insomnia, envio requisição POST para o endpoint perfil.<seuservidor>:8080 enviando o
payload: {e-mail: ”everton@pro.ucsal.br}.
1. O servidor ISP irá receber a requisição, consultar o servidor DNS para obter IP de acesso.
2. Servidor DNS recebe a requisição, consulta servidor Eureka obtendo a lista de aplicações
ativas
1. Consulta o endereço contido na requisição recebida do servidor ISP em caso encontre,
retorna para servidor ISP o IP.
1. Servidor ISP faz a chamada a aplicação com IP e porta e retorna resultado ao usuário
Importante: as únicas URLS que o cliente REST (insomnia, postman) deverá chamar são
validacao.localhost:8080 e perfil.localhost:8080.
Aplicações envolvidas. Cada uma terá uma funcionalidade específica:
## APLICAÇÃO PRINCIPAL - SERVIDOR ISP (LOCALHOST:8080) – Servidor que recebe as requisições do usuário
o Endpoint para recebimento das requisições
o Buscar lista de aplicações ativas
▪ Ao receber URL, buscar qual corresponde a solicitação (validação, perfis, permissões)
▪ Chamar aplicação mencionada na funcionalidade e retornar valor para usuário
▪ Caso ocorra qualquer erro, retornar para usuário
• APLICAÇÃO EUREKA SERVER - O mesmo do trabalho anterior
o Deverá possui um endpoint para obter todas aplicações ativas
• APLICAÇÃO SERVIDOR DE NOMES DNS – Obter lista de aplicações ativas e retornar para
Servidor ISP

• APLICAÇÃO A – VALIDAÇÃO (VALIDACAO.LOCALHOST:8080) – Efetua a validação de e-mail do
usuário
o Terá uma lista de e-mails em um ArrayList

o Na memória da aplicação deverá existir uma lista (ArrayList) contendo diversos usuários. Ao
receber solicitação com e-mail do usuário enviado pelo postman, verificar se ele está
presente na lista da Aplicação:
• APLICAÇÃO B – PERFIS (PERFIL.LOCALHOST:8080) – Verifica perfil do usuário
o Deverá existir dentro Aplicação B uma lista de perfis atrelados ao usuário
o Isto poderá ser implementado com um HashMap onde a chave é o e-mail e o valor o perfil
dele que pode ser: “Aluno, Professor, Funcionário”.
o HashMap<String, String> dados = new HashMap();
o Ex: dados = <”everton@pro.ucsal.br”, “Professor”>
Exemplo
• Insomnia envia validação do e-mail “everton.jesus@.pro.ucsal.br” ao servidor ISP
• ISP consulta no servidor de se e-mail existe { e-mail: everton@pro.ucsal.br}
o Caso exista retorna:
▪ Caso exista, retorna a mensagem: “E-mail do usuário everton.jesus@pro.ucsal.br existe
na base de dados.”
▪ Caso não exista, retornar mensagem informando que não foi encontrado.
• Solicita perfil do e-mail ao servidor ISP:
o Insomnia envia payload contendo {e-mail: ”everton@pro.ucsal.br)
o Recebe resultado: {e-mail: “everton.jesus@pro.ucsal.br”, perfil: “Professor”
o Se não for encontrado, retornar “Usuário não tem perfil”
