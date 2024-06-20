# 2a Unidade (nota 6)

## Aluno
Davi Fernandes Neves Costa

## Todas as Portas
**Legendas** <br />
👍 -> Funcionando  <br />
❌ -> Não está funcionando parcialmente ou totalmente


- ISP - 8080 👍
- DNS - 8081 ❌
- EUREKA - 8761 👍
- VALIDACAO APLICAÇÃO B - 8181 👍
- PERFIL APLICACAO A - 8182 ❌
- DFS APLICACAO A - 8281 ❌
- DFS APLICACAO B - 8282 👍
- DFS APLICACAO C - 8283 👍

## Dificuldades
- Não consegui implementer nada sobre o **Serviço do DNS**, pesquisei e estudei, porém não obtive êxito;
- Não consegui implementer o nó mestre **dfs-app-a (mestre)**, pensei na lógica e implementei porém há erros ao conectar com o serviço do dfs-app-b (nó) e dfs-app-c (nó);
- Como não consegui implementar o dfs-app-a (mestre), o serviço **perfil validação** também não funciona pois ele aciona o dfs-app-a (mestre), e como este não está funcionado, gera esse problema.
  
OBS: Mesmo não funcionando os end-points (get/post), o **Eureka Server reconhece todos esses microserviços.**

## Como rodar o projeto
- Baixa a extensão **Spring Boot Dashboard** no VsCode
- Rode primeiro o **eureka-server-app-main**
  
![Screenshot_1](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/a65798e3-8829-4519-b945-f59e82107f98)

- Agora rode todos os outros serviçoes
  
![Screenshot_2](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/5388789b-4427-498d-9545-0df19601eb96)

- Com todos os arquivos rodando, é possível testar ele!!!

![Screenshot_3](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/2561a410-3e49-4f67-b717-5828e2269297)


## Como testar o Projeto
- Configure no arquivos **DFS APLICACAO B** e **DFS APLICACAÇÃO C** onde é a rota para que os arquivos sejam guardados 
```
|- dfs-aplicacao-b
 |- src
  |- main
    |- java\com\example\dfs-aplicacao-b
      |- service
        |- StoregeService.java
            // ALTERE PARA O LOCAL DESEJADO
             private final String FOLDER_PATH = "C:/Users/ADM/Desktop/Files/AppB/";
```
```
|- dfs-aplicacao-c
 |- src
  |- main
    |- java\com\example\dfs-aplicacao-c
      |- service
        |- StoregeService.java
            // ALTERE PARA O LOCAL DESEJADO
             private final String FOLDER_PATH = "C:/Users/ADM/Desktop/Files/AppC/";
```
![Screenshot_6](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/e657c366-fc6a-4ea3-8bab-87e71cfcf9eb)

![Screenshot_7](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/adbfb89f-39fb-4c8d-98a9-05ed2839f7c0)

![Screenshot_4](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/c2ab1811-db76-47f8-8097-143c19aa4645)

![Screenshot_5](https://github.com/davimgfx/SD-Projeto-Unidade-2/assets/118557337/c1a644f0-8cc3-454b-b078-6a195d14c550)

