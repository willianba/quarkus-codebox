create table condos_resident_disc_comments (
	condo_id text not null,
	resident_disc_comments int not null
);

alter table condos_resident_disc_comments
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table condos_resident_disc_comments
add primary key (condo_id);