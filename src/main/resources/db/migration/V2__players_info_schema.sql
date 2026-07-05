CREATE TABLE players (
         id BIGSERIAL PRIMARY KEY NOT NULL,
         api_id BIGINT NOT NULL UNIQUE,
         name VARCHAR(255) NOT NULL,
         firstname VARCHAR(255),
         lastname VARCHAR(255),
         age SMALLINT,
         birth_date DATE,
         birth_place VARCHAR(255),
         birth_country VARCHAR(255),
         nationality VARCHAR(255),
         height SMALLINT,
         weight SMALLINT,
         jersey_number SMALLINT,
         position VARCHAR(100),
         photo_url TEXT,
         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_players_name ON players(name);
CREATE INDEX idx_players_nationality ON players(nationality);
CREATE INDEX idx_players_position ON players(position);