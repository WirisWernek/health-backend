CREATE MATERIALIZED VIEW situacao_atual_view as
	with cte_dados_situacao as (
		select * from situacao s 
		order by quando 
	)

  select ds2.* from (
	select  
	sistema,
	MAX(quando) as MaxTime
	from cte_dados_situacao
	group by sistema
	) as ds1
	inner join cte_dados_situacao ds2
	on ds2.sistema = ds1.sistema
	and ds1.MaxTime = ds2.quando
	order by ds1.sistema;