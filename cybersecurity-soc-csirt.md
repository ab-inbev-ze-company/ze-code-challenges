# Desafio de Cibersegurança SOC/CSIRT

## Sobre o desafio

Neste desafio será proposta uma situação hipotética na qual suspeita-se da ocorrência de um incidente de segurança no ambiente do Zé Delivery.
Você deverá interpretar as evidências disponíveis e comunicar suas conclusões e sugestões de ação sobre o caso.

## Cenário
- Você é membro da equipe de SOC/CSIRT do Zé Delivery;
- O Zé Delivery utiliza AWS como cloud provider para todos seus recursos;
- Os logs do cloudtrail são enviados para a ferramenta de SIEM;
- O Zé delivery utiliza o Google Workspace e Gmail como ferramentas de trabalho;

O SOC/CSIRT foi acionado quando, no dia 10/05/2022, a ferramenta de Threat Intelligence do Zé emitiu um alerta de mensagens, em um grupo de hackers no Telegram, nas quais hackers alegavam terem tido acesso a dados internos da empresa.

**Evidências coletadas até o momento:**
1. Google Admin Alert Center:
    - mai. 06, 2022, 08:48 AM -03 (2022-05-06T08:48:18-03:00) - 6 mensagens foram denunciadas como spam pelos usuários no seu domínio. 5 destinatários afetados.[joao@ze.delivery, marcos@ze.delivery, maria@ze.delivery, eduardo@ze.delivery, fernanda@ze.delivery];

2. Log da ferramenta de SIEM filtrando eventos de CreateAccessKey, disponível [neste](soc-csirt-files/search-results-siem.csv) arquivo;

3. Buscando identificar possíveis ações maliciosas, foi feito um levantamento recente de interações com as bases de dados Dynamodb e RDS, identificando os seguintes logs:
    - No dia 05/MAI/2022 às 11:00h GMT, o usuário "**ze-data**" realizou a leitura da base "**orders-data**", que continha dados de pedidos, sem informações sensíveis;
    - No dia 07/MAI/2022 às 10:00h GMT, o usuário "**zedelivery-safekey**" realizou a leitura da base "**consumers-data**", que continha dados pessoais sensíves de consumidores;
    - No dia 11/MAI/2022 às 15:00h GMT, o usuário "**ze-backend**" realizou a leitura da base "**geolocation**", que não continha dados sensíveis;

## O que precisamos
Com base nos dados acima, descreva:
- Se há indícios de que ocorreu realmente um ataque;
- Seu entendimento que como o ataque ocorreu, qual foi a forma de entrada e quais ações o atacante realizou no ambiente;
- Se existem indícios de que alguma informação sensível foi comprometida;
- Quais suas sugestões para conter e mitigar o incidente;


## Como você irá entregar

Por favor, envie o relatório contendo o seu racional, em um arquivo PDF, para o email **digital-protection_squad@ze.delivery**, com o assunto **"Desafio SOC/CSIRT"**.

## Prazo

Você tem 5 dias (120 horas) para realizar a entrega final, a partir do momento em que recebeu este desafio.

*Qualquer dúvida pode nos perguntar, mas no geral, divirta-se!*