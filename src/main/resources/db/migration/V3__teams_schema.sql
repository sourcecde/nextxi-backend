CREATE TABLE teams (
       id BIGINT PRIMARY KEY,

       venue_id BIGINT,

       name VARCHAR(255) NOT NULL,
       code VARCHAR(10),
       country VARCHAR(255),
       founded SMALLINT,
       national BOOLEAN NOT NULL DEFAULT FALSE,

       logo TEXT,

       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

       CONSTRAINT fk_team_venue FOREIGN KEY (venue_id) REFERENCES venues(id) ON DELETE SET NULL
);

CREATE INDEX idx_teams_country ON teams(country);
CREATE INDEX idx_teams_national ON teams(national);
CREATE INDEX idx_teams_venue ON teams(venue_id);

