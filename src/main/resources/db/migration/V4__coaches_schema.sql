CREATE TABLE coaches (
     id BIGINT PRIMARY KEY,

     current_team_id BIGINT,

     first_name VARCHAR(255),
     last_name VARCHAR(255),
     full_name VARCHAR(255) NOT NULL,

     age SMALLINT,

     birth_date DATE,
     birth_place VARCHAR(255),
     birth_country VARCHAR(255),

     nationality VARCHAR(255),

     height VARCHAR(20),
     weight VARCHAR(20),

     photo TEXT,

     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

     CONSTRAINT fk_coach_current_team FOREIGN KEY (current_team_id) REFERENCES teams(id) ON DELETE SET NULL
);



CREATE TABLE coach_careers (
       id BIGSERIAL PRIMARY KEY,

       coach_id BIGINT NOT NULL,
       team_id BIGINT NOT NULL,

       start_date DATE NOT NULL,
       end_date DATE,

       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

       CONSTRAINT fk_coach_career_coach FOREIGN KEY (coach_id) REFERENCES coaches(id) ON DELETE CASCADE,
       CONSTRAINT fk_coach_career_team FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE
);

CREATE INDEX idx_coach_current_team ON coaches(current_team_id);
CREATE INDEX idx_coach_nationality ON coaches(nationality);

CREATE INDEX idx_career_coach ON coach_careers(coach_id);
CREATE INDEX idx_career_team ON coach_careers(team_id);