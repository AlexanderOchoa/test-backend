CREATE TABLE public.chat_message (
                                     id bigserial NOT NULL,
                                     user_from_id int8 NOT NULL,
                                     user_to_id int8 NOT NULL,
                                     message_date timestamp NOT NULL,
                                     message varchar NOT NULL,
                                     CONSTRAINT chat_message_pk PRIMARY KEY (id),
                                     CONSTRAINT chat_message_user_chat_fk FOREIGN KEY (user_from_id) REFERENCES public.user_chat(id) ON DELETE CASCADE ON UPDATE CASCADE,
                                     CONSTRAINT chat_message_user_chat_fk_1 FOREIGN KEY (user_to_id) REFERENCES public.user_chat(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE public.test (
                             id bigserial NOT NULL,
                             "data" varchar NULL,
                             CONSTRAINT test_pk PRIMARY KEY (id)
);

CREATE TABLE public.user_chat (
                                  id bigserial NOT NULL,
                                  "name" varchar(30) NOT NULL,
                                  CONSTRAINT user_chat_pk PRIMARY KEY (id)
);

INSERT INTO public.test ("data") VALUES
    ('OK');
