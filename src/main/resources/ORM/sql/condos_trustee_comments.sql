create table condos_trustee_comments (
	condo_id text not null,
	trustee_comments int not null
);

alter table condos_trustee_comments
add constraint fk_condo foreign key (condo_id) references condos(condo_id) ON UPDATE CASCADE ON DELETE CASCADE;

alter table condos_trustee_comments
add primary key (condo_id);