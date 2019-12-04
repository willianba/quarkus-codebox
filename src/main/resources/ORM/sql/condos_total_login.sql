create table condos_total_login (
	condo_id text not null,
	total_logins int not null
);

alter table condos_total_login
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table condos_total_login
add primary key (condo_id);