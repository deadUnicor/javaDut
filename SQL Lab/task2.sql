
#===========================================================
# Task 2
#===========================================================

create table User(
    Id char(36) not null primary key ,
    Name varchar(36),
    Email varchar(64) not null
);

create table Role(
    Id char(36) not null primary key ,
    Name varchar(32),
    Description varchar(64)
);

create table UserInRole(
    Id char(36) not null primary key,
    UserId char(36) not null,
    RoleId char(36) not null,
    constraint FK_UserId FOREIGN KEY (UserId) references User (Id) on delete cascade,
    constraint FK_RoleId FOREIGN KEY (RoleId) references Role (Id) on delete cascade
);

insert INTO User(Id, Name, Email) VALUES
(UUID(),'Some Name', 'freemail'),
(UUID(),'Another name', 'gmail'),
(UUID(),'Total admin', 'securemail');

select * from User;

insert INTO Role(Id, Name, Description) VALUES
(UUID(),'Admin', 'Obviously'),
(UUID(),'User', 'No rights'),
(UUID(),'Api user', 'access to the api');

select * from Role;

insert into UserInRole(Id, UserId, RoleId) VALUES
(UUID(),'b6d10374-5124-11ec-96f5-0242ac120002','5520a8a1-5125-11ec-96f5-0242ac120002'),
(UUID(),'b6d0ff0f-5124-11ec-96f5-0242ac120002','5520a8a1-5125-11ec-96f5-0242ac120002'),
(UUID(),'b6d10150-5124-11ec-96f5-0242ac120002','5520aacc-5125-11ec-96f5-0242ac120002');

select * from UserInRole;

set @Role = 'Admin';
select * from User usr
    join UserInRole uir on usr.Id = uir.UserId
    join Role r on r.Id = uir.RoleId
where r.Name = @Role;
