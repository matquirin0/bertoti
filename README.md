1) <br>
A programação é o ato de escrever o código e a engenharia de software é a aplicação desse conhecimento para criar algo real e confiável. O texto diz que, conforme o software se torna essencial em nossas vidas, precisamos de um rigor similar ao da engenharia aeronáutica ou civil para evitar falhas graves.

2) <br>
A engenharia de software é definida como "programação integrada ao longo do tempo". Não basta apenas o código funcionar hoje; ele precisa ser sustentável. O foco está em três pilares:
Tempo e Mudança: O código deve ser capaz de evoluir e ser mantido por anos.
Escala e Crescimento: Como a organização e o sistema lidam com o aumento de usuários e dados.
Trade-offs: Como tomar decisões baseadas em custos e benefícios.

3) <br>
Os requisitos não funcionais não descrevem o que o sistema faz (funcionalidades), mas sim como ele deve se comportar.
Desempenho (Performance): Refere-se à agilidade do sistema. Não basta a função ser executada; ela precisa ocorrer dentro de um tempo aceitável.
Disponibilidade (Availability): É a garantia de que o sistema estará acessível quando o usuário precisar. Geralmente é medido em porcentagem.
Segurança (Security): Trata da proteção dos dados e do acesso. Garante que apenas pessoas autorizadas vejam certas informações e que o sistema resista a ataques maliciosos.
Escalabilidade (Scalability): É a capacidade do sistema de "crescer" para suportar um aumento de demanda (mais usuários ou mais dados) sem perder qualidade ou travar.
Usabilidade (Usability): Foca na facilidade de uso. Um sistema com boa usabilidade permite que o usuário aprenda a operá-lo rapidamente e cometa poucos erros durante a navegação.

4) <br>
Um trade-off ocorre quando a melhoria de um requisito prejudica diretamente outro. É a arte da negociação técnica. <br>
Cenário A: Segurança vs. Usabilidade 
Para tornar um aplicativo bancário extremamente seguro, você poderia exigir biometria, uma senha de 12 dígitos e um token enviado por SMS a cada clique.
O conflito: Enquanto a Segurança atinge o nível máximo, a Usabilidade cai drasticamente, pois o usuário demora muito para realizar tarefas simples, tornando a experiência frustrante. <br>
Cenário B: Desempenho vs. Custo 
Uma empresa quer que seu site de e-commerce carregue instantaneamente (em milissegundos) para milhares de usuários simultâneos.
O conflito: Para obter esse Desempenho, é necessário investir em servidores de altíssima performance e infraestrutura de ponta. O trade-off aqui é o Custo, que sobe consideravelmente para manter essa velocidade. <br>
Cenário C: Portabilidade vs. Desempenho 
Um desenvolvedor decide criar um jogo usando uma tecnologia que permite rodar o mesmo código no Windows, Android, iOS e Web.
O conflito: Ao focar na Portabilidade (rodar em qualquer lugar), perde-se em Desempenho. O código não é otimizado especificamente para o hardware de cada aparelho, resultando em uma execução mais lenta do que se fosse feito um código nativo para cada plataforma.
