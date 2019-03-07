# auth-rmi

Projeto RMI que implementa um servidor de autenticação e autorização que permita aos clientes:
- Cadastrar: nome, senha e permissão para uso de objetos
- Realizar autenticação/autorização, verificando:
    - Se o *login* do cliente está correto
    - Se ele tem autorização para usar um objeto e qual tipo de autorização ele tem (ler, ler/escrever, sem autorização)

**TODO**:
- [ ] Decidir qual será o objeto protegido pelo servidor e acessado pelo cliente
- [ ] Decidir quais serão as permissões 
- [ ] Implementar sign up 
- [ ] Implementar login
- [ ] Implementar controle de acesso

### Run

### Servidor

1. Os arquivos *java* podem ser compilados com o comando:
```
$ javac -d bin src/br/ufrn/imd/pd/*.java
```

2. Para gerar o arquivo *stub*
```
$ cd bin/
$ rmic br.ufrn.imd.pd.Auth
```

3. Inicie o Java RMI registry
```
$ rmiregistry
```

4. Rode o Servidor 
```
$ java -cp bin/ br.ufrn.imd.pd.AuthServer
```

### Cliente

1. O arquivo *stub* deve ficar dentro do diretório `bin/` do projeto Cliente. 

2. Execute o projeto usando o Eclipe ou compile os arquivos:
```
$ javac -d bin src/br/ufrn/imd/pd/*.java
```

3. E execute:
```
$ java -cp bin/ br.ufrn.imd.pd.AuthServer
```


**Referencia**: https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/hello/hello-world.html#startRegistry