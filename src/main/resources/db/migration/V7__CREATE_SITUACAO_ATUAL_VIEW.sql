CREATE MATERIALIZED VIEW situacao_atual_view as
	with cte_dados_health as (
		select * from health h  
		order by h.quando 
	)

  select 
  	dh2.id,
  	dh2.quando,
  	a.nome as ambiente,
  	s.nome as status,
  	c.nome as cliente
  from (
	select  
	clienteid,
	MAX(quando) as MaxTime
	from cte_dados_health
	group by clienteid
	) as dh1
	inner join cte_dados_health dh2
	on dh2.clienteid = dh1.clienteid
	and dh1.MaxTime = dh2.quando
	inner join ambiente a on a.id = dh2.ambienteid
	inner join status s on s.id = dh2.statusid
	inner join cliente c on c.id = dh2.clienteid
	order by dh1.clienteid;