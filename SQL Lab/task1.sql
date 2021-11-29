Create Database Lab8;

use Lab8;

Create table Comments(
    Id char(36) not null primary key,
    PostId char(36) not null,
    CommenterId char(36) not null,
    Likes int default 0,
    Time datetime(6) null,
    IsDeleted tinyint(1) default 0
);

insert into Comments(Id, PostId, CommenterId, Time) VALUE
(UUID(),UUID(),UUID(),curdate()),
(UUID(),UUID(),UUID(),curdate() ),
(UUID(),UUID(),UUID(),curdate() ),
(UUID(),UUID(),UUID(),curdate() ),
(UUID(),UUID(),UUID(),curdate() );

select * from Comments;





