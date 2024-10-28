CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.pokemon (
    id uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    weight DOUBLE PRECISION NOT NULL,
    base_experience INTEGER NOT NULL
);