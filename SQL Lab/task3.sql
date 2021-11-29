#===========================================================
# Task 3
#===========================================================

create table User(
    Id char(36) not null primary key ,
    Name varchar(36),
    Email varchar(64) not null,
    DateOfRegistration datetime(6) not null,
    LastEntered datetime(6)
);

create table Song(
    Id char(36) not null primary key ,
    Name varchar(36),
    CreatorId char(36) not null,
    IsPremium tinyint(1),
    Duration int,
    constraint FK_CreatorId_For_Song FOREIGN KEY (CreatorId) references User (Id) on delete restrict
);

create table LikedSongs(
    Id char(36) not null primary key,
    SongId char(36) not null,
    UserId char(36) not null,
    constraint FK_UserId_LikedSong FOREIGN KEY (UserId) references User (Id) on delete cascade,
    constraint FK_SongId_LikedSong FOREIGN KEY (SongId) references Song (Id) on delete cascade
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


create table Playlist(
    Id char(36) not null primary key ,
    Name varchar(64) not null,
    Description varchar(200)
);

create table UserInPlaylist(
    Id char(36) not null primary key ,
    UserId char(36) not null,
    PlaylistId char(36) not null,
    constraint FK_UserId_InPlaylist FOREIGN KEY (UserId) references User (Id) on delete cascade,
    constraint FK_PlaylistId_InPlaylist FOREIGN KEY (PlaylistId) references Playlist (Id) on delete cascade
);
