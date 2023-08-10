create or replace procedure refreshViews()
language plpgsql    
as $$
begin
	REFRESH MATERIALIZED VIEW situacao_atual_view ;
end;$$