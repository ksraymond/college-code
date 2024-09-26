use Top100;

select t.track_title, max(rd.charting_week)
from track t
join ranking_details rd on t.track_id=rd.track_id
join ranking_overview ro on t.track_id=ro.track_id
where rd.position_week like "1972%"
and ro.date_entered like "1972%"
group by t.track_title
order by max(rd.charting_week) desc
limit 2;