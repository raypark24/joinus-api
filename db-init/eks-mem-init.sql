CREATE SEQUENCE member_member_sn_seq;
CREATE TABLE member
(
    member_sn BIGINT NOT NULL UNIQUE DEFAULT nextval('member_member_sn_seq'),
    name VARCHAR(100) NOT NULL,
    login_id VARCHAR(300) NOT NULL,
    login_pwd VARCHAR(200) NOT NULL,
    tel_no_1 VARCHAR(20),
    tel_no_2 VARCHAR(20),
    created_dt TIMESTAMP WITH TIME ZONE,
    created_by VARCHAR(50),
    updated_dt TIMESTAMP WITH TIME ZONE,
    updated_by VARCHAR(50),
    PRIMARY KEY (member_sn)
);
CREATE SEQUENCE member_login_hi_gin_hist_sn_seq;
CREATE TABLE member_login_hist
(
    member_login_hist_sn BIGINT NOT NULL UNIQUE DEFAULT nextval('member_login_hi_gin_hist_sn_seq'),
    member_sn BIGINT NOT NULL,
    try_login_id TIMESTAMP WITH TIME ZONE NOT NULL,
    try_login_pwd VARCHAR(200) NOT NULL,
    login_success_yn VARCHAR(1) NOT NULL,
    created_dt TIMESTAMP WITH TIME ZONE NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_dt TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_by VARCHAR(50) NOT NULL,
    PRIMARY KEY (member_login_hist_sn)
);
ALTER TABLE IF EXISTS member_login_hist
    ADD CONSTRAINT member_login_hist_fk_1 FOREIGN KEY (member_sn) REFERENCES member (member_sn);