create table lobbyauths (
	condo_id text not null,
	creation_date timestamp not null,
	creator text not null,
	deleted boolean not null,
	auth_from_date timestamp not null
);

alter table lobbyauths
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table lobbyauths
add primary key (condo_id, creation_date, creator, auth_from_date);