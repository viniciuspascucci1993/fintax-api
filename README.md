# FinTax Core

**FinTax Core** é uma plataforma backend voltada para **simulação, preparação e organização do Imposto de Renda Pessoa Física (IRPF)**, com foco em centralização de dados financeiros, regras fiscais claras e arquitetura robusta.

O projeto nasce como um **side project sério**, com visão de produto real e potencial de evolução para um **SaaS**.

---

## 🎯 Objetivo

Simplificar o entendimento e a preparação do Imposto de Renda, permitindo que usuários:

- Organizem seus rendimentos, despesas e bens
- Simulem diferentes cenários de declaração (simplificado vs completo)
- Visualizem claramente imposto a pagar ou restituição
- Entendam **o porquê** dos cálculos aplicados

> ⚠️ O FinTax **não envia declarações à Receita Federal**.  
> O foco é **preparação, simulação e apoio à declaração**.

---

## 🧠 Visão do Produto

O FinTax não é apenas um formulário de preenchimento de IR.

A proposta é evoluir para uma **plataforma fiscal inteligente**, capaz de:

- Centralizar dados financeiros do usuário
- Aplicar regras fiscais de forma transparente
- Reduzir erros comuns na declaração
- Oferecer uma experiência moderna em um domínio tradicionalmente complexo

---

## 🧩 Escopo Inicial (MVP)

O MVP contempla:

- Cadastro e autenticação de usuários
- Cadastro manual de:
  - Rendimentos
  - Dependentes
  - Despesas dedutíveis
  - Bens e direitos
- Simulação automática do IRPF
- Comparação entre regimes:
  - Simplificado
  - Completo
- Resultado detalhado:
  - Imposto devido ou restituição
  - Explicações sobre regras aplicadas

---

## 🏗️ Arquitetura

O projeto segue princípios de:

- **Arquitetura Hexagonal (Ports & Adapters)**
- **Domain-Driven Design (DDD)**
- Separação clara entre:
  - Domínio
  - Aplicação
  - Infraestrutura

A regra fiscal é tratada como **núcleo do sistema**, desacoplada de frameworks e infraestrutura.

Mais detalhes em: [`/docs/architecture.md`](docs/architecture.md)

---

## 🛠️ Stack Tecnológica

- Java 17+
- Spring Boot
- Maven
- PostgreSQL
- Testes unitários focados no domínio
- Docker (em evolução)

---

## 📁 Estrutura do Repositório

fintax-core/
├── backend/ # Código da aplicação
├── docs/ # Documentação do projeto
├── infra/ # Infraestrutura (Docker, cloud, etc)
└── README.md

## 🚀 Status do Projeto

🟡 **Em desenvolvimento inicial**

O projeto encontra-se em fase de definição de domínio, escopo e arquitetura base.

---

## 📌 Roadmap

O roadmap do projeto está documentado em:
- [`docs/roadmap.md`](docs/roadmap.md)

---

## ⚖️ Aviso Legal

Este projeto possui caráter **educacional e experimental**.  
Não substitui um contador profissional nem garante conformidade legal com a Receita Federal.

---

## 👤 Autor

Projeto idealizado e desenvolvido por **Vinícius Pascucci**  

