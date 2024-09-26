use Top100;

select distinct t1.track_title, p.person as artist, ro.highest, ro.date_peaked
from track t1
join track t2 on t2.track_title = t1.track_title and t2.artist != t1.artist
join people p on p.person_id = t1.artist
join ranking_overview ro on ro.track_id = t1.track_id
where t1.track_year = 1969
and t2.track_year=1969
order by t1.track_title, ro.highest;