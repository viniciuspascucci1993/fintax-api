# Roadmap — FinTax Core

Este documento descreve a evolução planejada do **FinTax Core**, desde o MVP inicial até possíveis expansões futuras do produto.

O roadmap é incremental e orientado a valor, priorizando regras fiscais, clareza de domínio e arquitetura sólida.

---

## 🟢 Fase 1 — Fundação do Produto (MVP)

Objetivo: entregar uma **simulação funcional e confiável do IRPF**, com foco em regra de negócio e clareza para o usuário.

### Funcionalidades
- Cadastro e autenticação de usuários
- Cadastro manual de dados fiscais:
  - Rendimentos
  - Dependentes
  - Despesas dedutíveis
  - Bens e direitos
- Simulação do Imposto de Renda Pessoa Física
- Comparação automática entre:
  - Regime simplificado
  - Regime completo
- Resultado detalhado:
  - Imposto devido ou restituição
  - Justificativa das regras aplicadas

### Aspectos Técnicos
- Modelagem de domínio baseada em DDD
- Arquitetura Hexagonal (Ports & Adapters)
- Regra fiscal desacoplada de infraestrutura
- Testes unitários focados no domínio
- API REST para consumo futuro (frontend ou terceiros)

---

## 🟡 Fase 2 — Organização e Automação de Dados

Objetivo: reduzir a entrada manual e aumentar a confiabilidade dos dados.

### Funcionalidades
- Importação de dados via:
  - Arquivos CSV
  - PDFs (informes de rendimentos)
- Normalização e categorização automática de dados
- Validação de inconsistências fiscais
- Alertas de possíveis erros ou omissões

### Aspectos Técnicos
- Módulos de importação desacoplados
- Estratégias de parsing e validação
- Logs estruturados e rastreabilidade de dados
- Tratamento de erros e exceções de domínio

---

## 🔵 Fase 3 — Integrações Externas (Opcional / Avançado)

Objetivo: centralizar dados financeiros automaticamente.

### Funcionalidades
- Integração com Open Finance (sandbox)
- Sincronização de:
  - Contas bancárias
  - Rendimentos
  - Investimentos
- Pré-preenchimento da simulação de IR

### Aspectos Técnicos
- Integração com APIs externas
- Gestão de tokens e consentimento
- Isolamento de integrações em adapters
- Mecanismos de retry e resiliência

---

## 🟣 Fase 4 — Evolução para SaaS

Objetivo: transformar o FinTax em um produto escalável.

### Funcionalidades
- Multi-tenancy (empresas e usuários)
- Perfis de acesso (usuário, contador, admin)
- Histórico de simulações por ano
- Exportação de dados e relatórios
- Monitoramento e métricas de uso

### Aspectos Técnicos
- Escalabilidade horizontal
- Observabilidade (logs, métricas, tracing)
- Infraestrutura como código
- Preparação para cloud (AWS/GCP/Azure)

---

## 🧭 Observações

- O roadmap pode evoluir conforme aprendizados do domínio
- O foco inicial é **qualidade de regra fiscal**, não volume de funcionalidades
- Cada fase é independente e incremental
