use Top100;

select distinct t.track_title, p.person as artist
from track t
join people p on p.person_id = t.artist
join ranking_details rd on rd.track_id = t.track_id
where rd.position_week like "1969-07%"
	and rd.track_rank <= 10
order by p.person;