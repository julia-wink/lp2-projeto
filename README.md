# Cadastro de Disciplinas

Sistema de gerenciamento escolar desenvolvido em Java com o objetivo de registrar e manter o cadastro de disciplinas, professores e cursos de uma instituição de ensino.

## 🚀 Tecnologias e Práticas Utilizadas
- Java
- Programação Orientada a Objetos (POO)
- Princípios SOLID (Inversão de Dependência, Responsabilidade Única)
- Arquitetura baseada em Domain-Driven Design (DDD - em escala simplificada)

## 📋 Requisitos Implementados

- **R1 - Cadastro de Professores:** Gerencia as informações (código funcional, nome e data de nascimento).
- **R2 - Cadastro de Cursos:** Gerencia informações do curso (código, nome e descrição).
- **R3 - Registro de Disciplinas:** Relaciona as disciplinas aos respectivos professores responsáveis e ao curso, armazenando número, nome, data de início e data de encerramento.
- **R4 - Validação de Data:** Garante que a data de início da disciplina não seja anterior à data corrente.

## 🏗 Estrutura do Projeto

O projeto foi dividido em camadas lógicas para aplicar as práticas recomendadas de Clean Code e SOLID:

- **domain/model:** Classes de domínio (`Professor`, `Curso`, `Disciplina`); onde também estão as regras de negócio intrínsecas (ex.: validação de data).
- **domain/repository:** Interfaces que definem os contratos de acesso a dados, facilitando a injeção de dependência.
- **service:** Camada de serviço contendo as regras de negócio orquestradas da aplicação, consumindo as interfaces de repositórios.

## 🎨 Diagrama de Classes
A modelagem do sistema pode ser visualizada no arquivo [diagrama_classes.mmd](diagrama_classes.mmd) presente na raiz deste repositório.
