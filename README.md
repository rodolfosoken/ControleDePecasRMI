# ControleDePecasRMI
Projeto para a disciplina de Sistemas Distribuídos.

Este é um programa simples que ilustra o uso das chamadas de métodos remotos. 

O programa realiza o controle de peças em repositórios remotos através de clientes, que podem ou não estar em computadores diferentes. 
Para manipular os repositórios de peças, os clientes utilizam chamadas de métodos remotos através do Java RMI.

O Java RMI é um mecanismo que permite a utilização de métodos que existem em diferentes máquinas virtuais Java (JVM), estas podendo estar em diferentes máquinas ou não. Aplicações RMI são frequentemente compostas  por dois programas (cliente e servidor). O servidor cria os objetos remotos e espera pelo acesso remoto a estes objetos pelos clientes. O cliente possui acesso a um ou mais destes objetos (que pode existir em diversos servidores) e utiliza os métodos existentes neles. O Java RMI fornece mecanismos para facilitar a comunicação entre o cliente e o servidor.

O Java RMI é melhor utilizado em implementações cujos dados a serem transmitidos entre cliente e servidor não forem muito grandes (como, por exemplo, a transmissão de várias strings). Isto ocorre devido a codificação de 16 bits utilizada pelo Java RMI para a transmissão de dados.

Este sistema será composto por múltiplos servidores, cada qual representando um repositório de informação sobre as peças, e clientes, utilizados para interagir com a interface do servidor. Cada servidor deverá conter as informações sobre as partes que ali foram armazenadas, sendo capaz de armazenar uma nova peça, resgatar a informação de uma peça existente e obter uma lista de todas as peças armazenadas. As peças podem ser primitivas ou compostas por outras peças. Neste caso, elas devem conter informações indicando de quais peças elas são compostas e a quantidade necessária de cada uma destas peças.

