/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/12/2021 7:10:42 p. m.                      */
/*==============================================================*/


/*==============================================================*/
/* Table: citas                                                 */
/*==============================================================*/
create table citas
(
   idcita               bigint not null auto_increment  comment '',
   idmedico             bigint not null  comment '',
   idusuario            bigint not null  comment '',
   fecha                date not null  comment '',
   hora                 time not null  comment '',
   consultorio          bigint not null  comment '',
   consulta             varchar(1000) not null  comment '',
   diagnostico          varchar(1000) not null  comment '',
   tratamiento          varchar(1000) not null  comment '',
   estado               char(1) not null  comment '',
   primary key (idcita)
);

/*==============================================================*/
/* Table: medicos                                               */
/*==============================================================*/
create table medicos
(
   idmedico             bigint not null  comment '',
   idusuario            bigint not null  comment '',
   especialidad         varchar(200) not null  comment '',
   jornada              char(1) not null  comment '',
   primary key (idmedico)
);

/*==============================================================*/
/* Table: roles                                                 */
/*==============================================================*/
create table roles
(
   idrol                bigint not null auto_increment  comment '',
   nombrerol            varchar(100) not null  comment '',
   primary key (idrol)
);

/*==============================================================*/
/* Table: usuarios                                              */
/*==============================================================*/
create table usuarios
(
   idusuario            bigint not null auto_increment  comment '',
   idrol                bigint not null  comment '',
   clave                varchar(20) not null  comment '',
   identificacion       bigint not null  comment '',
   nombreusuario        varchar(200) not null  comment '',
   direccion            varchar(200) not null  comment '',
   telefono             bigint not null  comment '',
   correo               varchar(200) not null  comment '',
   primary key (idusuario)
);

alter table citas add constraint fk_citas_reference_medicos foreign key (idmedico)
      references medicos (idmedico) on delete restrict on update cascade;

alter table citas add constraint fk_citas_reference_usuarios foreign key (idusuario)
      references usuarios (idusuario) on delete restrict on update cascade;

alter table medicos add constraint fk_medicos_reference_usuarios foreign key (idusuario)
      references usuarios (idusuario) on delete restrict on update cascade;

alter table usuarios add constraint fk_usuarios_reference_roles foreign key (idrol)
      references roles (idrol) on delete restrict on update cascade;

