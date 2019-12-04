create table alerts (
	condo_id text not null,
	creation_date timestamp not null,
	deleted boolean not null
);

alter table alerts
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table alerts
add primary key (condo_id, creation_date);
