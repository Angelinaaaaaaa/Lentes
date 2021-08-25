# Lentes
* Equipe: Angelina Machado de Siqueira; Julia Moura de Morais Sales;
* Problema: Criar um sistema que permita que os usuários consultem se devem ou não usar lentes de contato, se sim então o sistema informará o tipo. Pensando no usuário com suas caracteristicas e podendo no sistema responder as perguntas apresentadas para  obter o seu resultado.
* Dataset: Lense. link: https://archive.ics.uci.edu/ml/datasets/Lenses
* Técnica: A técnica da árvore de decisão será utilizada para resolver o problema, ela permitirá que o sistema faça a melhor classificação dos dados inseridos pelo usuário. Com a implementação da árvore de decisão treinada no sistema. As variáveis consideradas pela árvore de decisão são a taxa de produção de lágrimas e o astigmático. Os valores possíveis da variável taxa são "reduzida" e "normal", já os da variável astigmático são "não" e "sim". As saídas da árvore de decisão são "não","leve" e "forte". A árvore de decisão adequada foi implementada no software Weka, que teve como resposta a menor árvore que obtém a decisão com menos testes. Como a escolha dos nós, foram escolhidos os atributos mais importantes, fazendo a maior diferença na classificação. A estratégia de validação cruzada utilizada foi o Holdout, que dividirá o dataset em dois subconjuntos, "treinamento" e "teste" (80% e 20%). A melhor métrica utilizada para medir o desempenho destas árvores foi o Recall.
* Resultados obtidos: Utilizando o houldout com três subconjuntos obtivemos três matrizes de confusão, e as metricas de acúracia e o recall, a partir desses resultados escolhemosnseguir o que obteve o melhor recall, no caso (80/20) para o holdout, mesmo com essa escolha, ela não necessariamente apresentou o resultado perfeito, mas o que obteve melhor predição.
* Instruções de uso do software: O software pode ser executado através do download do projeto em formato ZIP pelo Github, ou também através da execução do comando abaixo no terminal: 

  Deve-se acessar a pasta TrabalhoINC para a execução do arquivo. 
  O sistema permitirá que o usuário digite as respostas pré programadas pelo software para executar a predição. 
  
 * Vídeos: 
   Vídeo1:  Apresentação do Problema, Técnica utilizada e Resultados obtidos: https://youtu.be/xRW36t-7sL8
   Vídeo3:  Conclusões: https://youtu.be/8lKXNVOGljI
