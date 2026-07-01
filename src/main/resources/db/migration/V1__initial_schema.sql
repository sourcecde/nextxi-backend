CREATE TABLE countries (
       id BIGSERIAL PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       code VARCHAR(10) NOT NULL UNIQUE,
       flag TEXT,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE timezones (
       id BIGSERIAL PRIMARY KEY,
       timezone_name VARCHAR(100) NOT NULL UNIQUE,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE venues (
        id BIGSERIAL PRIMARY KEY,
        api_id INTEGER UNIQUE NOT NULL,
        name VARCHAR(255) NOT NULL,
        address VARCHAR(255),
        city VARCHAR(100),
        country VARCHAR(100),
        capacity INTEGER,
        surface VARCHAR(50),
        image TEXT,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);