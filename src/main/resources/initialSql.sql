CREATE TABLE USER (
	USER_ID BIGINT,
	USER_NM VARCHAR(50),
	PSWRD VARCHAR(50),
	EMAIL VARCHAR(50),
	FRST_NM VARCHAR(50),
	LST_NM VARCHAR(50),
	ROLE VARCHAR(3),
	ENTRY_DTTM TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT USER_PK PRIMARY KEY(USER_ID),
	CONSTRAINT UNIQUE_USER_NM UNIQUE(USER_NM)
	);
	
CREATE TABLE KUDO (
	KUDO_ID BIGINT,
	KUDOER BIGINT,
	KUDEE BIGINT,
	CMNT VARCHAR(500),
	ENTRY_DTTM TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT KUDO_PK PRIMARY KEY(KUDO_ID)
	);
	
CREATE TABLE VOTE (
	VOTE_ID BIGINT,
	KUDO_ID BIGINT NOT NULL,
	ENTRY_USER BIGINT,
	ENTRY_DTTM TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT VOTE_PK PRIMARY KEY(VOTE_ID),
	CONSTRAINT UNIQUE_VOTE UNIQUE(KUDO_ID, ENTRY_USER)
	);
	
CREATE TABLE ABUSE (
	ABUSE_ID BIGINT NOT NULL,
	KUDO_ID BIGINT NOT NULL,
	CMNT VARCHAR(500),
	ENTRY_USER BIGINT,
	ENTRY_DTTM TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT ABUSE_PK PRIMARY KEY(ABUSE_ID),
	CONSTRAINT UNIQUE_ABUSE UNIQUE(KUDO_ID, ENTRY_USER)
	);
	
CREATE SEQUENCE USER_ID_SEQ MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOCYCLE;
CREATE SEQUENCE KUDO_ID_SEQ MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOCYCLE;
CREATE SEQUENCE VOTE_ID_SEQ MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOCYCLE;
CREATE SEQUENCE ABUSE_ID_SEQ MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOCYCLE;
	
CREATE TABLE REF_ROLE (
	CODE VARCHAR(3),
	DSC VARCHAR(50),
	CONSTRAINT REF_ROLE_PK PRIMARY KEY(CODE)
	);
	
INSERT INTO REF_ROLE ( CODE, DSC ) VALUES ( 'SUP', 'SUPERVISOR' );
INSERT INTO REF_ROLE ( CODE, DSC ) VALUES ( 'EMP', 'EMPLOYEE' );