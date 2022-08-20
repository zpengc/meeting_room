

# db

create table. monash;



docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7



# table

## user_info table

```sql
create table user_info (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '登陆用户名',
  `password` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '登陆密码',
  `ctime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON
  UPDATE
    CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(4) NOT NULL DEFAULT 0 COMMENT '0-正常，1-封禁，2-离职',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=816 DEFAULT CHARSET=utf8mb4 COMMENT='用户注册信息表'
```





## room_info table

```sql
create table room_info (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '会议室名称',
  `description` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '会议室主题',
  `ctime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON
  UPDATE
    CURRENT_TIMESTAMP COMMENT '更新时间',
  `capacity` int(11) NOT NULL DEFAULT 0 COMMENT '容量',
  `has_projector` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0-没有投影仪，1-有投影仪',
  `has_laptop` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0-没有平板，1-有平板',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0-未删除，1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_name` (`name`),
  KEY `idx_capacity` (`capacity`),
  KEY `idx_has_laptop` (`has_laptop`),
  KEY `idx_has_projector` (`has_projector`),
  KEY `idx_deleted` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=816 DEFAULT CHARSET=utf8mb4 COMMENT='会议室信息表'
```





## room_reservation table

```sql
create table room_reservation (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `room_id` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '会议室id',
  `username` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '预定人',
  `ctime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON
  UPDATE
    CURRENT_TIMESTAMP COMMENT '更新时间',
  `stime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预定开始时间',
  `etime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预定结束时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0-未删除，1-删除',
  PRIMARY KEY (`id`),
  KEY `idx_room_id` (`room_id`),
  KEY `idx_username` (`username`),
  KEY `idx_deleted` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=816 DEFAULT CHARSET=utf8mb4 COMMENT='会议室预定记录表'
```



## role table

```sql
create table role (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_desc` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '角色描述',
  `ctime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON
  UPDATE
    CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int(4) NOT NULL DEFAULT 0 COMMENT '0-未删除，1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_role_name` (`role_name`),
  KEY `idx_deleted` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=816 DEFAULT CHARSET=utf8mb4 COMMENT='角色表'
```



## role_permit table

```sql
create table role_permit (
  `id` BIGINT(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` BIGINT(20) unsigned NOT NULL DEFAULT 0 COMMENT '角色id',
  `permit` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '权限名称',
  `ctime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON
  UPDATE
    CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0-未删除，1-删除',
  PRIMARY KEY (`id`),
  KEY `uniq_role_id` (`role_id`),
  KEY `uniq_permit` (`permit`),
  KEY `idx_deleted` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=816 DEFAULT CHARSET=utf8mb4 COMMENT='权限角色关联表'
```





# 踩的坑

**mysql timestamp 如何 和jpa的类型映射**

使用Date类型即可，增加Temporal 注解

```sql
@Temporal(TemporalType.TIMESTAMP)
public Date createdAt;
```



**Hibernate的 entity name问题**

@Query("select id, username, ctime, mtime from user_info where status = 0")
    public List<User> list();

user_info是entity name，默认是class name，如果更改，用@Entity的name属性设置



**table name使用use**

user是mysql系统表。重名





# 常用注解

`@Transactional` annotation is used when you want the certain method/class(=all methods inside) to be executed in a transaction.

If you don't specify `@Transactional`, each DB call will be in a different transaction.



