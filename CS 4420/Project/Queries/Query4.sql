use Top100;

select p.person as artist, t.track_title, ro.date_peaked, ro.highest
from people p
join track t on t.artist = p.person_id
join ranking_overview ro on ro.track_id = t.track_id
where t.track_year = 1969 and ro.highest = 1
order by ro.date_peaked;