PGDMP  ,                    }            aluno_online_p3b    17.4    17.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16437    aluno_online_p3b    DATABASE     v   CREATE DATABASE aluno_online_p3b WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pt-BR';
     DROP DATABASE aluno_online_p3b;
                     postgres    false            �            1259    16640    aluno    TABLE     �   CREATE TABLE public.aluno (
    "id-aluno" bigint NOT NULL,
    "cpf-aluno" character varying(255),
    "email-aluno" character varying(255),
    "nome-aluno" character varying(255)
);
    DROP TABLE public.aluno;
       public         heap r       postgres    false            �            1259    16639    aluno_id-aluno_seq    SEQUENCE     �   ALTER TABLE public.aluno ALTER COLUMN "id-aluno" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public."aluno_id-aluno_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    218            �            1259    16684 
   disciplina    TABLE     �   CREATE TABLE public.disciplina (
    id_disciplina bigint NOT NULL,
    carga_horaria integer,
    nome_disciplina character varying(255),
    professor_id bigint
);
    DROP TABLE public.disciplina;
       public         heap r       postgres    false            �            1259    16683    disciplina_id_disciplina_seq    SEQUENCE     �   ALTER TABLE public.disciplina ALTER COLUMN id_disciplina ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.disciplina_id_disciplina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    220            �            1259    16690    matricula_aluno    TABLE     �  CREATE TABLE public.matricula_aluno (
    id_matricula bigint NOT NULL,
    nota_1 double precision,
    nota_2 double precision,
    status_aluno character varying(255),
    aluno_id_aluno bigint,
    disciplina_id_disciplina bigint,
    CONSTRAINT matricula_aluno_status_aluno_check CHECK (((status_aluno)::text = ANY ((ARRAY['MATRICULADO'::character varying, 'APROVADO'::character varying, 'REPROVADO'::character varying, 'TRANCADO'::character varying])::text[])))
);
 #   DROP TABLE public.matricula_aluno;
       public         heap r       postgres    false            �            1259    16689     matricula_aluno_id_matricula_seq    SEQUENCE     �   ALTER TABLE public.matricula_aluno ALTER COLUMN id_matricula ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.matricula_aluno_id_matricula_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    222            �            1259    16697 	   professor    TABLE     �   CREATE TABLE public.professor (
    id_professor bigint NOT NULL,
    cpf_professor character varying(255),
    email_professor character varying(255),
    nome_professor character varying(255)
);
    DROP TABLE public.professor;
       public         heap r       postgres    false            �            1259    16696    professor_id_professor_seq    SEQUENCE     �   ALTER TABLE public.professor ALTER COLUMN id_professor ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.professor_id_professor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    224            �          0    16640    aluno 
   TABLE DATA           U   COPY public.aluno ("id-aluno", "cpf-aluno", "email-aluno", "nome-aluno") FROM stdin;
    public               postgres    false    218   "       �          0    16684 
   disciplina 
   TABLE DATA           a   COPY public.disciplina (id_disciplina, carga_horaria, nome_disciplina, professor_id) FROM stdin;
    public               postgres    false    220   ^#       �          0    16690    matricula_aluno 
   TABLE DATA              COPY public.matricula_aluno (id_matricula, nota_1, nota_2, status_aluno, aluno_id_aluno, disciplina_id_disciplina) FROM stdin;
    public               postgres    false    222   �#       �          0    16697 	   professor 
   TABLE DATA           a   COPY public.professor (id_professor, cpf_professor, email_professor, nome_professor) FROM stdin;
    public               postgres    false    224   $       �           0    0    aluno_id-aluno_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."aluno_id-aluno_seq"', 10, true);
          public               postgres    false    217            �           0    0    disciplina_id_disciplina_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.disciplina_id_disciplina_seq', 4, true);
          public               postgres    false    219            �           0    0     matricula_aluno_id_matricula_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.matricula_aluno_id_matricula_seq', 9, true);
          public               postgres    false    221            �           0    0    professor_id_professor_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.professor_id_professor_seq', 5, true);
          public               postgres    false    223            2           2606    16646    aluno aluno_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY ("id-aluno");
 :   ALTER TABLE ONLY public.aluno DROP CONSTRAINT aluno_pkey;
       public                 postgres    false    218            4           2606    16688    disciplina disciplina_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (id_disciplina);
 D   ALTER TABLE ONLY public.disciplina DROP CONSTRAINT disciplina_pkey;
       public                 postgres    false    220            6           2606    16695 $   matricula_aluno matricula_aluno_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.matricula_aluno
    ADD CONSTRAINT matricula_aluno_pkey PRIMARY KEY (id_matricula);
 N   ALTER TABLE ONLY public.matricula_aluno DROP CONSTRAINT matricula_aluno_pkey;
       public                 postgres    false    222            8           2606    16703    professor professor_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (id_professor);
 B   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_pkey;
       public                 postgres    false    224            :           2606    16714 +   matricula_aluno fk8wvua3x319ud1ohn8xrxvv4kx    FK CONSTRAINT     �   ALTER TABLE ONLY public.matricula_aluno
    ADD CONSTRAINT fk8wvua3x319ud1ohn8xrxvv4kx FOREIGN KEY (disciplina_id_disciplina) REFERENCES public.disciplina(id_disciplina);
 U   ALTER TABLE ONLY public.matricula_aluno DROP CONSTRAINT fk8wvua3x319ud1ohn8xrxvv4kx;
       public               postgres    false    220    4660    222            ;           2606    16709 +   matricula_aluno fkergf8w4uabbrpxxuntwud9ctq    FK CONSTRAINT     �   ALTER TABLE ONLY public.matricula_aluno
    ADD CONSTRAINT fkergf8w4uabbrpxxuntwud9ctq FOREIGN KEY (aluno_id_aluno) REFERENCES public.aluno("id-aluno");
 U   ALTER TABLE ONLY public.matricula_aluno DROP CONSTRAINT fkergf8w4uabbrpxxuntwud9ctq;
       public               postgres    false    4658    218    222            9           2606    16704 &   disciplina fkoqie7f1kx32b1atco9fpgxd7g    FK CONSTRAINT     �   ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT fkoqie7f1kx32b1atco9fpgxd7g FOREIGN KEY (professor_id) REFERENCES public.professor(id_professor);
 P   ALTER TABLE ONLY public.disciplina DROP CONSTRAINT fkoqie7f1kx32b1atco9fpgxd7g;
       public               postgres    false    224    220    4664            �   <  x�e�Mn�@�יS��v���Z~*�R%d����#τ6=}�
�^Xz����ĝ8�T؉�Zb��܀�QF&�i��|D�-�Ft�Ȇ9����<�ӂ�����W�\��
�,z�c�ߕ��

�nʑ\��
��%2�~\���U��lNJcj��Ƙ%Y���]�ígȎ(����d��э���Q�e6ו�b�f���f��=�w�nc��Jk�[uB'�mp
̨uo�4
�@��P�3���Z��9q���q�L?�~'�E�n��ڬ~��	_�B�L������ I��Ra�+:S:���Ziɠ�����Q��      �   =   x�3�0���,.9��(3�Ӑ�$��X��{xaIfr"�	�1H����bט������ �la      �   X   x�u�1
�0D�z�0��D�e�FP#A�r�s��+L����}G�˶<{Z3Bo�2�(�N���ߎ�"�q�vMFӕ���O�:���/j      �   �   x�]�͊�@�s�)�vh�o�z�]^�f��&��"}{��h9%�$��(�ҽ�*��MR��L)�v�u��%�+6�<�=#�6�)�!�zUE��Q��ݎ3��o8(���=e���~{g��cBd{��G��������G�Cʨ��������'6˩m@qh�;�b���Ɠ�Q��c%X$     