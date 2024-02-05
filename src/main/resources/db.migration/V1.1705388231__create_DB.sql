CREATE TABLE IF NOT EXISTS public.client (
                                             id bigserial PRIMARY KEY,
                                             full_name VARCHAR NOT NULL,
                                             email VARCHAR NOT NULL,
                                             phone_number VARCHAR NOT NULL,
                                             company_name VARCHAR NOT NULL,
                                             task_description VARCHAR(2000)
    );

CREATE TABLE IF NOT EXISTS public.intern (
                                             id bigserial PRIMARY KEY,
                                             full_name VARCHAR NOT NULL,
                                             email VARCHAR NOT NULL,
                                             phone_number VARCHAR NOT NULL,
                                             description VARCHAR(5000) NOT NULL,
    city VARCHAR NOT NULL
    );

CREATE TABLE IF NOT EXISTS public.dev (
                                          id bigserial PRIMARY KEY,
                                          full_name VARCHAR NOT NULL,
                                          job_title VARCHAR NOT NULL,
                                          description VARCHAR(5000) NOT NULL,
    contacts VARCHAR NOT NULL,
    frame VARCHAR(5000)
    );

CREATE TABLE IF NOT EXISTS public.reviews (
                                              id bigserial PRIMARY KEY,
                                              full_name VARCHAR NOT NULL,
                                              review VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS public.news (
                                           id bigserial PRIMARY KEY,
                                           text VARCHAR NOT NULL
);
