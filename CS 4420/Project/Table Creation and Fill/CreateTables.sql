use Top100;

create table if not exists people (
	person_id int primary key auto_increment,
    person varchar(100) not null
    );
    
create table if not exists label (
	label_id int primary key auto_increment,
    label_name varchar(50) not null
    );

create table if not exists track (
	track_id int primary key auto_increment,
    track_year int not null,
    track_title varchar(100) not null,
    track_time varchar(10) not null,
    label_id int,
    bpm varchar(3) not null,
    track_comment varchar(1000),
    prefix varchar(10) not null,
    artist int,
    lab_num varchar(20),
    foreign key (label_id) references label(label_id),
	foreign key (artist) references people(person_id)
    
    );
    
create table if not exists track_writers (
	track_id int,
    person_id int,
    writer_num int,
    
    primary key (track_id, person_id)
    );
    
create table if not exists ranking_overview (
	track_id int primary key,
    weeks_ch int not null,
    weeks_40 int not null,
    weeks_10 int not null,
    yearly_rank varchar(10) not null,
    weeks_peak int not null,
    highest int not null,
    date_entered varchar(20),
    date_peaked varchar(20)
    );
    
create table if not exists ranking_details (
	track_id int,
    charting_week int,
    track_rank int not null,
    position_week date,
    
    primary key (track_id, charting_week)
    );