if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('express') and o.name = 'FK_EXPRESS_LIST_EXPR_LIST')
alter table express
   drop constraint FK_EXPRESS_LIST_EXPR_LIST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('list') and o.name = 'FK_LIST_LIST_BUYE_BUYER')
alter table list
   drop constraint FK_LIST_LIST_BUYE_BUYER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('list') and o.name = 'FK_LIST_LIST_EXPR_EXPRESS')
alter table list
   drop constraint FK_LIST_LIST_EXPR_EXPRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('list_product') and o.name = 'FK_LIST_PRO_LIST_PROD_PRODUCT')
alter table list_product
   drop constraint FK_LIST_PRO_LIST_PROD_PRODUCT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('list_product') and o.name = 'FK_LIST_PRO_LIST_PROD_LIST')
alter table list_product
   drop constraint FK_LIST_PRO_LIST_PROD_LIST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('product') and o.name = 'FK_PRODUCT_PRODUCT_T_TYPE')
alter table product
   drop constraint FK_PRODUCT_PRODUCT_T_TYPE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('buyer')
            and   type = 'U')
   drop table buyer
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('express')
            and   name  = 'order_express2_FK'
            and   indid > 0
            and   indid < 255)
   drop index express.order_express2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('express')
            and   type = 'U')
   drop table express
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('list')
            and   name  = 'order_express_FK'
            and   indid > 0
            and   indid < 255)
   drop index list.order_express_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('list')
            and   name  = 'order_user_FK'
            and   indid > 0
            and   indid < 255)
   drop index list.order_user_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('list')
            and   type = 'U')
   drop table list
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('list_product')
            and   name  = 'order_product_FK'
            and   indid > 0
            and   indid < 255)
   drop index list_product.order_product_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('list_product')
            and   name  = 'order_product2_FK'
            and   indid > 0
            and   indid < 255)
   drop index list_product.order_product2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('list_product')
            and   type = 'U')
   drop table list_product
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('product')
            and   name  = 'product_type_FK'
            and   indid > 0
            and   indid < 255)
   drop index product.product_type_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('product')
            and   type = 'U')
   drop table product
go

if exists (select 1
            from  sysobjects
           where  id = object_id('type')
            and   type = 'U')
   drop table type
go

/*==============================================================*/
/* Table: buyer                                                 */
/*==============================================================*/
create table buyer (
   user_id              char(20)             not null,
   user_name            varchar(20)          not null,
   user_age             char(10)             not null,
   user_sex             char(10)             not null,
   user_telephone       varchar(20)          not null,
   user_address         varchar(40)          not null,
   user_password        char(20)             not null,
   constraint PK_BUYER primary key (user_id)
)
go

/*==============================================================*/
/* Table: express                                               */
/*==============================================================*/
create table express (
   express_id           char(20)             not null,
   order_id             char(50)             not null,
   express_infomation   varchar(10)          not null,
   express_courierid    char(20)             not null,
   express_couriername  varchar(10)          not null,
   express_couriertelephone char(20)             not null,
   constraint PK_EXPRESS primary key (express_id)
)
go

/*==============================================================*/
/* Index: order_express2_FK                                     */
/*==============================================================*/
create index order_express2_FK on express (
order_id ASC
)
go

/*==============================================================*/
/* Table: list                                                  */
/*==============================================================*/
create table list (
   order_id             char(50)             not null,
   user_id              char(20)             not null,
   express_id           char(20)             not null,
   order_time           char(20)             not null,
   order_money          float                not null,
   order_state          varchar(20)          not null,
   order_buyername      varchar(20)          not null,
   order_sellername     varchar(20)          not null,
   order_productname    varchar(20)          not null,
   order_productnumber  int                  not null,
   constraint PK_LIST primary key (order_id)
)
go

/*==============================================================*/
/* Index: order_user_FK                                         */
/*==============================================================*/
create index order_user_FK on list (
user_id ASC
)
go

/*==============================================================*/
/* Index: order_express_FK                                      */
/*==============================================================*/
create index order_express_FK on list (
express_id ASC
)
go

/*==============================================================*/
/* Table: list_product                                          */
/*==============================================================*/
create table list_product (
   product_id           char(30)             not null,
   order_id             char(50)             not null,
   constraint PK_LIST_PRODUCT primary key (product_id, order_id)
)
go

/*==============================================================*/
/* Index: order_product2_FK                                     */
/*==============================================================*/
create index order_product2_FK on list_product (
order_id ASC
)
go

/*==============================================================*/
/* Index: order_product_FK                                      */
/*==============================================================*/
create index order_product_FK on list_product (
product_id ASC
)
go

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product (
   product_id           char(30)             not null,
   type_id              char(20)             not null,
   product_name         char(20)             not null,
   product_price        float(20)            not null,
   product_color        char(10)             not null,
   product_type         varchar(10)          not null,
   constraint PK_PRODUCT primary key (product_id)
)
go

/*==============================================================*/
/* Index: product_type_FK                                       */
/*==============================================================*/
create index product_type_FK on product (
type_id ASC
)
go

/*==============================================================*/
/* Table: type                                                  */
/*==============================================================*/
create table type (
   type_id              char(20)             not null,
   type_name            varchar(20)          not null,
   constraint PK_TYPE primary key (type_id)
)
go

alter table express
   add constraint FK_EXPRESS_LIST_EXPR_LIST foreign key (order_id)
      references list (order_id)
go

alter table list
   add constraint FK_LIST_LIST_BUYE_BUYER foreign key (user_id)
      references buyer (user_id)
go

alter table list
   add constraint FK_LIST_LIST_EXPR_EXPRESS foreign key (express_id)
      references express (express_id)
go

alter table list_product
   add constraint FK_LIST_PRO_LIST_PROD_PRODUCT foreign key (product_id)
      references product (product_id)
go

alter table list_product
   add constraint FK_LIST_PRO_LIST_PROD_LIST foreign key (order_id)
      references list (order_id)
go

alter table product
   add constraint FK_PRODUCT_PRODUCT_T_TYPE foreign key (type_id)
      references type (type_id)
go
