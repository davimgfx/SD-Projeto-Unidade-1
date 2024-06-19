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



