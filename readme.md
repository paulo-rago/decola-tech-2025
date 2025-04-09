# Diagrama ER - StudyBuddy

```mermaid
erDiagram
    USUARIO ||--o{ COMPROMISSO : possui
    USUARIO ||--o{ LEMBRETE : recebe
    USUARIO ||--o{ NOTIFICACAO : tem
    USUARIO }o--|| CURSO : pertence_a

    CURSO ||--o{ DISCIPLINA : contem
    DISCIPLINA ||--o{ COMPROMISSO : relacionado_a

    COMPROMISSO ||--o{ LEMBRETE : gera
    COMPROMISSO ||--o{ NOTIFICACAO : dispara

    USUARIO {
        int id PK
        string nome
        string email
        string senha_hash
        datetime criado_em
    }

    CURSO {
        int id PK
        string nome
        string descricao
    }

    DISCIPLINA {
        int id PK
        string nome
        string codigo
        int curso_id FK
    }

    COMPROMISSO {
        int id PK
        string titulo
        string descricao
        datetime data_hora
        string local
        int usuario_id FK
        int disciplina_id FK
    }

    LEMBRETE {
        int id PK
        datetime data_hora
        string mensagem
        int usuario_id FK
        int compromisso_id FK
    }

    NOTIFICACAO {
        int id PK
        string tipo
        string canal
        datetime enviado_em
        bool lido
        int usuario_id FK
        int compromisso_id FK
    }
