use Top100;

select p.person as composer, t.track_title, ro.highest
from people p
join track t
join track_writers tw on tw.track_id = t.track_id and tw.person_id = p.person_id
join ranking_overview ro on ro.track_id = t.track_id
where ro.highest = 1 and t.track_year = 1972
order by p.person;