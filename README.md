# Educake
#### The English School Manager
> Caraca, tio tinha escrito pra ca:boom:lho aqui e acabei copiando os arquivos antigos em cima, esquecendo que ainda não tinha dado push nesse... :angry:

## Instalação
Na verdade não tem bem uma instalação, é só seguir os passos abaixo:
  1. Dar clone do repositório:
    - `git clone https://github.com/PrintFSolutions/Educake.git`;
  2. Abrir na sua IDE e transformar em projeto **Maven** caso ele não descubra sozinho (geralmente Eclipse);
  3. Puxar as dependências e executar;
  4. **TROUBLESHOOT (geralmente NetBeans)**
    - **Não é possível encontrar dependências X: [CORRIGIDO]** Vá na lista de dependências da sua IDE e remova o `mysql-connector-java-5.1.23-bin` e o `hibernate-jpamodelgen-4.3.1-Final` e mande _Construir com dependências_ que ele fará o download novamente;
    - **Erro de execução com Maven:** Por algum motivo o Netbeans não encontra o arquivo `Main.java` (possivelmente pela falta dos arquivos das propriedades utilizados pelo Netbeans), clique com o botão direito no arquivo e mande _executar o arquivo_, ou entre no arquivo e pressione `SHIFT+F6`.
