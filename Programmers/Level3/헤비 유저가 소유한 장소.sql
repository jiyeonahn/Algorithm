SELECT * FROM places WHERE host_id IN(
SELECT host_id FROM places GROUP BY host_id having count(*) > 1);