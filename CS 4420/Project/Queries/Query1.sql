use Top100;

select rd.track_rank, t.track_title, p.person as artist, ro.date_entered
from ranking_details rd 
join track t on t.track_id = rd.track_id
join people p on t.artist = p.person_id
join ranking_overview ro on ro.track_id = t.track_id
where rd.position_week="1968-09-07"
order by rd.track_rank asc;