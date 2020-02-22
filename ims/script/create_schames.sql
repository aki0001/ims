create table account (
  account_id number ,
  password varchar2(100) ,
  first_name varchar2(100) ,
  last_name varchar2(100) ,
  e_mail varchar2(100) ,
  enable number default 0 ,
  display_name varchar2(100),
  primary key (account_id)
  using index(
    create unique index account_pk
    on account(account_id)
  )
);

create table authority (
  account_id number,
  role_id    number,
  primary key (account_id,role_id)
  using index(
    create unique index authority_pk
    on authority(account_id,role_id)
  ),
  constraint authority_account_id_fk
  foreign key(account_id)
  references account(account_id),
  constraint authority_role_id_fk
  foreign key(role_id)
  references role(role_id)
);

create table role (
  role_id number,
  role_name varchar2(100),
  primary key (role_id)
  using index(
    create unique index role_pk
    on role(role_id)
  )
);

create table operation_log (
  id number,
  operation_time date,
  operation_user_id number,
  operation_id number
);