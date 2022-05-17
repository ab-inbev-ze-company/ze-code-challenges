# Desafio de Cibersegurança BLUE TEAM

## Contexto
Você faz parte do time de CyberSecurity do Zé e um novo serviço interno será implementado, envolvendo os times de site reabillity engineering, de desenvolvimento e de segurança.

Os times responsáveis pela implementação e manutenção do serviço são:

Time A - Produto
- Squad Backend A
- Squad Frontend A

Time B - Plataforma
- Squad de S.R.E B	
- Squad DBRE B

Time C 
- Cybersecurity

Um novo ambiente (*nova conta da AWS*) vai ser disponibilizada apenas para utilização desse serviço, sendo totalmente segmentado dos outros ambientes, em uma nova VPC apartada.

Levando isso em consideração, alguns requisitos foram listados:

Definir políticas para utilização de Banco de dados (RDS), lembrando que essa base irá conter dados pessoais sensíveis.

*Exemplos*: configurações de utilização das instâncias garantindo confidencialidade, integridade e disponibilidade.

Construir infraestrutura segura, utilizando os seguintes recursos: 

- Load balancers
- ECS
- ECR
- S3


Estes recursos devem se comunicar com a base de dados acima mencionada e a aplicação deverá ser disponibilizada na internet.

Dois buckets S3 devem ser criados, sendo um utilizado para publicar um site estático e outro para armazenamento de dados transacionais a serem utilizados pelo time interno de Data.

Os requisitos foram designados para cada time da seguinte forma:

Time A:
- A Squad de Backend será responsável por implementar toda lógica e regras de negócio, além de interagir com a infraestrutura.

- A Squad de Frontend será responsável por implementar o site estático, além de interagir com a infraestrutura.

Time B:
- A Squad de SRE será responsável por implementar toda infraestrutura computacional, que vai do Load Balancers, Cluster e gestão das imagens Docker utilizando infraestrutura como código, utilizando Terraform.

- A Squad de DBA/DBRE será responsável por implementar toda infraestrutura de Banco de Dados utilizando infraestrutura como código, também Terraform.

Cybersecurity (VOCÊ):
- Desenhar um diagrama da infraestrutura proposta. Esse desenho será utilizado como referência para os outros times (utilize a ferramenta de sua preferência);
- Implementar toda a configuração dos buckets S3 utilizando infraestrutura como código, em Terraform.
- Texto explicativo contendo as políticas para banco de dados e demais requisitos de segurança.
- Políticas IAM (no formato JSON) com acessos segmentados por time, squads e recursos.

Considerando que você é um membro do time de Cybersecurity, realize as entregas do time, solicitadas acima.

## Orientações Gerais
Será considerado para a avaliação a clareza do documento, organização de ideias e os aspectos técnicos propostos. Esperamos um desenvolvimento de raciocínio lógico, demonstrando grandes conhecimentos em infraestrutura Cloud, além das melhores práticas de segurança atuais. 

## Importante

 Por favor, crie um repositório **privado** no Github documentando o seu racional e com o(s) diagrama(s). Para o diagrama, sinta-se à vontade para usar qualquer tipo de ferramenta para gerá-lo - na extensão de sua escolha - estamos apenas interessados ​​no conteúdo.

Não se esqueça de adicionar o @ze-engineering-code-challenge como colaborador para o seu repositório **privado**. Esta conta do Github (**@ze-engineering-code-challenge**) é usada exclusivamente pelos engenheiros da Zé para baixar e revisar o seu desafio.

Após o compartilhamento do seu repositório, envie um email para **digital-protection_squad@ze.delivery** e informe a pessoa recrutadora, informando a conclusão do teste. 
