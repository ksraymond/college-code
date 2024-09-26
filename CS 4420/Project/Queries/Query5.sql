use Top100;

select t.track_title, p.person as artist, ro.highest
from track t
join people p on p.person_id = t.artist
join track_writers tw on tw.person_id = p.person_id and tw.track_id = t.track_id
join ranking_overview ro on ro.track_id = t.track_id
where tw.person_id = t.artist 
	and ro.highest <= 20
    and t.track_year = 1973
order by p.person;