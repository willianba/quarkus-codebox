create table discussions (
	condo_id text not null,
	creation_date timestamp not null,
	first_creator text not null,
	second_creator text not null,
	deleted boolean not null
);

alter table discussions
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table discussions
add primary key (condo_id, creation_date, first_creator, second_creator);