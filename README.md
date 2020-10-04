# ProvaDTI

## Solução
Para representar a solução, foi criado um diagrama de classes, como pode ser visto na imagem abaixo.
 ![Logo do R](https://i.ibb.co/yFmBv8G/prova-Dti-Diagrama.png)
 
 O programa conta com três classes principais, GerenciamentoPetshop,Petshop e Preco.
 
 
### GerenciamentoPetshop
É responsável pela principal logica de negocio, que é buscar o pet shop adequado de acordo com o menor preço, caso o preço seja igual, o pet shop escolhido será o de menor distância.
Esta classe também contempla o método Preencher dados. Este método é de suma importância para a aplicação, pois, como não existe um banco de dados tradicional, este método preenche as informações dos pet shops em tempo de execução.

### Petshop
Contém informações básicas do pet shop, como nome e distância. Além disso, contém uma lista de preços de banhos para os doguinhos.

### Preco
Por cada pet shop poder conter até quatro preços (Pequeno,Grande, Dia de semana e final de semana), foi criada uma classe para otimizar este ponto. Caso futuramente fosse necessário implementar outra condição, como por exemplo cachorros de médio porte, será bem mais fácil implementar, além de facilitar a manutenção do código.

## Premissas 


Para padronizar os dados, foi definido que a distancia será calculada em kilometros, sendo assim, foi necessário converter a distância do canil ChowChawgas manualmente.
Seguindo esta linha, o valor do banho nos finais de semana do do pet shop Meu Canino Feliz já foram inseridos com seus respectivos reajustes.


## Instruções para executar o sistema
O executavel do programa esta em "ProvaDTI\out\artifacts\ProvaDTI_jar". 


É possível executá lo passando os parâmetros
<data MM/DD/AAAA> <quantidade de cães pequenos> <quantidade cães grandes>
	`Java -jar ProvaDTI.jar 10/04/2020 3 5`

Também é possível executar o programa sem inserir os parâmetros inicialmente. Neste caso, será solicitado inserir as informações através do console.
	`Java -jar ProvaDTI.jar`