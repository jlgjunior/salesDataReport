# salesDataReport
Generates sales report from text input files

Cria as saídas no repositório out com o nome do aquivo de entrada + extensão com o horario corrente.
<br/>
<br/>
Inicialmente ia fazer com banco de dados pois considerei que o enunciado era para que os dados fossem cumulativos, mas um dia antes da data de entrega eu reli e apesar de achar o enunciado dúbio quanto a isso vi que não fazia sentido para um grande numero de arquivos já que as vendas referenciam o vendedor pelo nome e pode haver duas pessoas com o mesmo nome, então considerei que os relatórios desejados seriam por arquivo. Sendo assim, desisti no final da implementação com ORM usando hibernate.
<br/>
<br/>
A aplicação foi feita com spring boot e maven, para executar é só estar na pasta principal do projeto e rodar o comando "mvn clean install" (também é gerado um .jar).
<br/>
<br/>
O cálculo de pior vendedor ficou um pouco ineficiente porque a especificação não afirmava que os dados estariam na ordem (primeiro viria vendendores, depois clientes, depois vendas), então fiz uma considerando qualquer ordem no arquivo (mas ainda espera o arquivo no formato correto).
