use Top100;

select t.track_title, p.person as artist, rd.track_rank
from track t
join people p on p.person_id = t.artist
join ranking_details rd on rd.track_id = t.track_id
where rd.position_week = "1964-04-04"
and rd.track_rank <= 40
order by rd.track_rank asc;