use Top100;

# get all individual people
insert into people(person)
select distinct artist
from top100
union
select distinct writtenby1
from top100
union
select distinct writtenby2
from top100
union
select distinct writtenby3
from top100
union
select distinct writtenby4
from top100
union
select distinct writtenby5
from top100
union
select distinct writtenby6
from top100
union
select distinct writtenby7
from top100
union
select distinct writtenby8
from top100
;

# build label table
insert into label (label_name)
select distinct label
from top100;

#built track table
insert into track (track_year, track_title, track_time, label_id, bpm, track_comment, prefix, artist, lab_num)
select a.year, a.tracktitle, a.time, c.label_id, a.bpm, a.comment, a.prefix, b.person_id, a.labnum
from top100 a
join people b on a.artist=b.person
join label c on a.label=c.label_name;

#build ranking_overview table
insert into ranking_overview (track_id, weeks_ch, weeks_40, weeks_10, yearly_rank, weeks_peak, highest, date_entered, date_peaked)
select a.track_id, b.weeksCH, b.weeks40, b.weeks10, b.yearlyrank, b.weekspeak, b.highest, b.dateentered, b.datepeaked
from top100 b
join track a on a.track_title=b.tracktitle and a.prefix = b.prefix;

#build track_writers linking table
insert into track_writers (track_id, person_id, writer_num)
select t.track_id, p.person_id, 
case 
	when p.person = a.writtenby1 then 1
    when p.person = a.writtenby2 then 2
    when p.person = a.writtenby3 then 3
    when p.person = a.writtenby4 then 4
    when p.person = a.writtenby5 then 5
    when p.person = a.writtenby6 then 6
    when p.person = a.writtenby7 then 7
    else 8
end
from track t
join people p 
join top100 a on t.prefix=a.prefix 
where (p.person = a.writtenby1 and char_length(writtenby1)>0) or
	(p.person = a.writtenby2 and char_length(writtenby2)>0) or
	(p.person = a.writtenby3 and char_length(writtenby3)>0) or
    (p.person = a.writtenby4 and char_length(writtenby4)>0) or
    (p.person = a.writtenby5 and char_length(writtenby5)>0) or
    (p.person = a.writtenby6 and char_length(writtenby6)>0) or
    (p.person = a.writtenby7 and char_length(writtenby7)>0) or
    (p.person = a.writtenby8 and char_length(writtenby8)>0)
;

#make temp rankings table
drop table if exists temp_rankings;
create table temp_rankings (
	track_id int,
    charting_week int,
    track_rank int not null,
    position_week date,
    
    primary key (track_id, charting_week)
    );

#build ranking_details table
insert into temp_rankings (track_id, charting_week, track_rank)
select t.track_id, 1, a.week1
from track t
join top100 a on t.prefix=a.prefix where a.week1>0
union all 
select t.track_id, 2, a.week2
from track t
join top100 a on t.prefix = a.prefix where a.week2 > 0
union all 
select t.track_id, 3, a.week3
from track t
join top100 a on t.prefix = a.prefix where a.week3 > 0
union all 
select t.track_id, 4, a.week4
from track t
join top100 a on t.prefix = a.prefix where a.week4 > 0
union all 
select t.track_id, 5, a.week5
from track t
join top100 a on t.prefix = a.prefix where a.week5 > 0
union all 
select t.track_id, 6, a.week6
from track t
join top100 a on t.prefix = a.prefix where a.week6 > 0
union all 
select t.track_id, 7, a.week7
from track t
join top100 a on t.prefix = a.prefix where a.week7 > 0
union all 
select t.track_id, 8, a.week8
from track t
join top100 a on t.prefix = a.prefix where a.week8 > 0
union all 
select t.track_id, 9, a.week9
from track t
join top100 a on t.prefix = a.prefix where a.week9 > 0
union all 
select t.track_id, 10, a.week10
from track t
join top100 a on t.prefix = a.prefix where a.week10 > 0
union all 
select t.track_id, 11, a.week11
from track t
join top100 a on t.prefix = a.prefix where a.week11 > 0
union all 
select t.track_id, 12, a.week12
from track t
join top100 a on t.prefix = a.prefix where a.week12 > 0
union all 
select t.track_id, 13, a.week13
from track t
join top100 a on t.prefix = a.prefix where a.week13 > 0
union all 
select t.track_id, 14, a.week14
from track t
join top100 a on t.prefix = a.prefix where a.week14 > 0
union all 
select t.track_id, 15, a.week15
from track t
join top100 a on t.prefix = a.prefix where a.week15 > 0
union all 
select t.track_id, 16, a.week16
from track t
join top100 a on t.prefix = a.prefix where a.week16 > 0
union all 
select t.track_id, 17, a.week17
from track t
join top100 a on t.prefix = a.prefix where a.week17 > 0
union all 
select t.track_id, 18, a.week18
from track t
join top100 a on t.prefix = a.prefix where a.week18 > 0
union all 
select t.track_id, 19, a.week19
from track t
join top100 a on t.prefix = a.prefix where a.week19 > 0
union all 
select t.track_id, 20, a.week20
from track t
join top100 a on t.prefix = a.prefix where a.week20 > 0
union all 
select t.track_id, 21, a.week21
from track t
join top100 a on t.prefix = a.prefix where a.week21 > 0
union all 
select t.track_id, 22, a.week22
from track t
join top100 a on t.prefix = a.prefix where a.week22 > 0
union all 
select t.track_id, 23, a.week23
from track t
join top100 a on t.prefix = a.prefix where a.week23 > 0
union all 
select t.track_id, 24, a.week24
from track t
join top100 a on t.prefix = a.prefix where a.week24 > 0
union all 
select t.track_id, 25, a.week25
from track t
join top100 a on t.prefix = a.prefix where a.week25 > 0
union all 
select t.track_id, 26, a.week26
from track t
join top100 a on t.prefix = a.prefix where a.week26 > 0
union all 
select t.track_id, 27, a.week27
from track t
join top100 a on t.prefix = a.prefix where a.week27 > 0
union all 
select t.track_id, 28, a.week28
from track t
join top100 a on t.prefix = a.prefix where a.week28 > 0
union all 
select t.track_id, 29, a.week29
from track t
join top100 a on t.prefix = a.prefix where a.week29 > 0
union all 
select t.track_id, 30, a.week30
from track t
join top100 a on t.prefix = a.prefix where a.week30 > 0
union all 
select t.track_id, 31, a.week31
from track t
join top100 a on t.prefix = a.prefix where a.week31 > 0
union all 
select t.track_id, 32, a.week32
from track t
join top100 a on t.prefix = a.prefix where a.week32 > 0
union all 
select t.track_id, 33, a.week33
from track t
join top100 a on t.prefix = a.prefix where a.week33 > 0
union all 
select t.track_id, 34, a.week34
from track t
join top100 a on t.prefix = a.prefix where a.week34 > 0
union all 
select t.track_id, 35, a.week35
from track t
join top100 a on t.prefix = a.prefix where a.week35 > 0
union all 
select t.track_id, 36, a.week36
from track t
join top100 a on t.prefix = a.prefix where a.week36 > 0
union all 
select t.track_id, 37, a.week37
from track t
join top100 a on t.prefix = a.prefix where a.week37 > 0
union all 
select t.track_id, 38, a.week38
from track t
join top100 a on t.prefix = a.prefix where a.week38 > 0
union all 
select t.track_id, 39, a.week39
from track t
join top100 a on t.prefix = a.prefix where a.week39 > 0
union all 
select t.track_id, 40, a.week40
from track t
join top100 a on t.prefix = a.prefix where a.week40 > 0
union all 
select t.track_id, 41, a.week41
from track t
join top100 a on t.prefix = a.prefix where a.week41 > 0
union all 
select t.track_id, 42, a.week42
from track t
join top100 a on t.prefix = a.prefix where a.week42 > 0
union all 
select t.track_id, 43, a.week43
from track t
join top100 a on t.prefix = a.prefix where a.week43 > 0
union all 
select t.track_id, 44, a.week44
from track t
join top100 a on t.prefix = a.prefix where a.week44 > 0
union all 
select t.track_id, 45, a.week45
from track t
join top100 a on t.prefix = a.prefix where a.week45 > 0
union all 
select t.track_id, 46, a.week46
from track t
join top100 a on t.prefix = a.prefix where a.week46 > 0
union all 
select t.track_id, 47, a.week47
from track t
join top100 a on t.prefix = a.prefix where a.week47 > 0
union all 
select t.track_id, 48, a.week48
from track t
join top100 a on t.prefix = a.prefix where a.week48 > 0
union all 
select t.track_id, 49, a.week49
from track t
join top100 a on t.prefix = a.prefix where a.week49 > 0
union all 
select t.track_id, 50, a.week50
from track t
join top100 a on t.prefix = a.prefix where a.week50 > 0
union all 
select t.track_id, 51, a.week51
from track t
join top100 a on t.prefix = a.prefix where a.week51 > 0
union all 
select t.track_id, 52, a.week52
from track t
join top100 a on t.prefix = a.prefix where a.week52 > 0
union all 
select t.track_id, 53, a.week53
from track t
join top100 a on t.prefix = a.prefix where a.week53 > 0
union all 
select t.track_id, 54, a.week54
from track t
join top100 a on t.prefix = a.prefix where a.week54 > 0
union all 
select t.track_id, 55, a.week55
from track t
join top100 a on t.prefix = a.prefix where a.week55 > 0
union all 
select t.track_id, 56, a.week56
from track t
join top100 a on t.prefix = a.prefix where a.week56 > 0
union all 
select t.track_id, 57, a.week57
from track t
join top100 a on t.prefix = a.prefix where a.week57 > 0
union all 
select t.track_id, 58, a.week58
from track t
join top100 a on t.prefix = a.prefix where a.week58 > 0
union all 
select t.track_id, 59, a.week59
from track t
join top100 a on t.prefix = a.prefix where a.week59 > 0
union all 
select t.track_id, 60, a.week60
from track t
join top100 a on t.prefix = a.prefix where a.week60 > 0
union all 
select t.track_id, 61, a.week61
from track t
join top100 a on t.prefix = a.prefix where a.week61 > 0
union all 
select t.track_id, 62, a.week62
from track t
join top100 a on t.prefix = a.prefix where a.week62 > 0
union all 
select t.track_id, 63, a.week63
from track t
join top100 a on t.prefix = a.prefix where a.week63 > 0
union all 
select t.track_id, 64, a.week64
from track t
join top100 a on t.prefix = a.prefix where a.week64 > 0
union all 
select t.track_id, 65, a.week65
from track t
join top100 a on t.prefix = a.prefix where a.week65 > 0
union all 
select t.track_id, 66, a.week66
from track t
join top100 a on t.prefix = a.prefix where a.week66 > 0
union all 
select t.track_id, 67, a.week67
from track t
join top100 a on t.prefix = a.prefix where a.week67 > 0
union all 
select t.track_id, 68, a.week68
from track t
join top100 a on t.prefix = a.prefix where a.week68 > 0
union all 
select t.track_id, 69, a.week69
from track t
join top100 a on t.prefix = a.prefix where a.week69 > 0
union all 
select t.track_id, 70, a.week70
from track t
join top100 a on t.prefix = a.prefix where a.week70 > 0
union all 
select t.track_id, 71, a.week71
from track t
join top100 a on t.prefix = a.prefix where a.week71 > 0
union all 
select t.track_id, 72, a.week72
from track t
join top100 a on t.prefix = a.prefix where a.week72 > 0
union all 
select t.track_id, 73, a.week73
from track t
join top100 a on t.prefix = a.prefix where a.week73 > 0
union all 
select t.track_id, 74, a.week74
from track t
join top100 a on t.prefix = a.prefix where a.week74 > 0
union all 
select t.track_id, 75, a.week75
from track t
join top100 a on t.prefix = a.prefix where a.week75 > 0
union all 
select t.track_id, 76, a.week76
from track t
join top100 a on t.prefix = a.prefix where a.week76 > 0
;

#copy temp table into ranking_details and do position week math
insert into ranking_details (track_id, charting_week, track_rank, position_week)
select a.track_id, a.charting_week, a.track_rank, date_add(date(b.date_entered), interval (a.charting_week-1) week)
from temp_rankings a
join ranking_overview b on a.track_id=b.track_id
where b.date_entered != "0";

drop table temp_rankings;