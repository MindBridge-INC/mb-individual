# mb-individual
Entregas individuais | Sprint 2 -> jar conectando ao banco de dados

# Como Aplicar o Looca API?

 1° O looca disponibiliza os recursos do computador como se fossem "classes" dentro de cada objeto 
 
 2° Para acessar os dados mais especificos do looca, primeiro deve-se criar as instâncias desses objetos
 
            `Processador processador = looca.getProcessador;`
            
  com isso, estamos dizendo para o programa que o objeto processador está recebendo os atributos vindos do `getProcessador`.
  
 3° Agora precisamos dizer para o programa, qual atributo queremos de dentro do recurso processador.
 
           ` processador.getFabricante();`
           
 **Atenção!!**
 
 É preciso importar o recurso antes de utilizá-lo. Aperte o tab após escrever o objeto ou aperte a lâmpada vermelha e realize a importação.

### O que tem em um computador?
O que convém que seja monitorado?
Responder essas perguntas ajuda muito a agilizar na construção de seu projeto!
Vamos criar uma classe que tenha alguns recuros que queremos manipular.

`public class Computador{`

     private String sistemaOperacional;
  
     private Integer qtdMemoria;
` }`
