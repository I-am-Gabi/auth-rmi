# auth-rmi

Projeto RMI que implementa um servidor de autenticação e autorização que permita aos clientes:
- Cadastrar: nome, senha e autorização para uso de objetos
- Realizar autenticação/autorização, verificando:
    - Se o *login* do cliente está correto
    - Se ele tem autorização para usar um objeto e qual tipo de autorização ele tem (ler, ler/escrever, sem autorização)


### Run

### Server Side

1. The source files can be compiled as follows:
```
$ javac -d bin src/br/ufrn/imd/pd/*.java
```

2. Generate stub file
```
$ rmic br.ufrn.imd.pd.Auth
```

3. Start the Java RMI registry
```
$ rmiregistry
```

4. Run Server Project 
```
$ java -cp bin/ br.ufrn.imd.pd.AuthServer
```

### Client Side

1. The stub file should be inside the bin folder 

2. Run the project using eclipse ide or compile the files:
```
$ javac -d bin src/br/ufrn/imd/pd/*.java
```

3. And run it:
```
$ java -cp bin/ br.ufrn.imd.pd.AuthServer
```