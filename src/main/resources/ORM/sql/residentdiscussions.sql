create table resident_discussions (
	condo_id text not null,
	creation_date timestamp not null,
	creator text not null,
	deleted boolean not null
);

alter table resident_discussions
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table resident_discussions
add primary key (condo_id, creation_date, creator);