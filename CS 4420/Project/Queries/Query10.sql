use Top100;

select t.track_title, p.person as artist, ro.date_peaked
from track t
join people p on p.person_id = t.artist
join ranking_overview ro on ro.track_id = t.track_id
where t.track_year = 1968
and ro.highest <= 10
and ro.highest > 5
order by ro.date_peaked, ro.highest;