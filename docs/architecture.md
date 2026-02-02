# Architecture — FinTax Core

## Visão Geral

O FinTax Core é construído com foco em **regra de negócio, testabilidade e evolução**, adotando uma arquitetura que separa claramente domínio, aplicação e infraestrutura.

---

## Estilo Arquitetural

- Arquitetura Hexagonal (Ports & Adapters)
- Domain-Driven Design (DDD)
- Clean Architecture

---

## Camadas do Sistema

### Domain
- Entidades fiscais (Income, Deduction, Asset, TaxDeclaration)
- Regras de cálculo do IR
- Políticas fiscais por ano
- Independente de frameworks

### Application
- Casos de uso (Use Cases)
- Orquestração do domínio
- Regras de fluxo e validação

### Adapters
- REST API
- Persistência
- Importação de arquivos
- Integrações externas (futuro)

### Infrastructure
- Banco de dados
- Configurações
- Segurança
- Observabilidade

---

## Princípios Técnicos

- Domínio não depende de frameworks
- Infraestrutura depende da aplicação, não o contrário
- Regra fiscal é testada de forma isolada
- Adapters são intercambiáveis

---

## Segurança

- Autenticação baseada em token
- Autorização por escopo
- Criptografia de dados sensíveis
- Princípios de LGPD by design

---

## Evolução

A arquitetura foi projetada para permitir:

- Adição de novas regras fiscais
- Inclusão de integrações externas
- Evolução para SaaS
- Escalabilidade horizontal
