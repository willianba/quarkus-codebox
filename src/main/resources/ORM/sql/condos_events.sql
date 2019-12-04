create table condos_events (
	condo_id text not null,
	events int not null
);

alter table condos_events
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table condos_events
add primary key (condo_id);