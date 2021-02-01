-- create view offre_view
create or replace view imo_offre_view as 
   SELECT iOf.id, iOf.create_at, iOf.update_at, iOf.code_postal, iOf.complement_adresse, iOf.libelle_rue,
   iOf.numero_rue, iOf.pays, iOf.ville, iOf.description, iOf.prix, iOf.titre, iOf.users_id, iOf.type_offre,
   iOf.type_service_offre, iOf.date_debut, iOf.date_fin, iOf.code_offre, mo.motoriser, mo.batterie, mo.duree_batterie,
   mo.date_mise_en_circulation, mo.kilometrage, mo.model, mo.nombre_porte, mo.type_bien_mobile, mo.nombre_roue, 
   immo.autre_service, immo.zone_geographique, immo.parking, immo.electricite, immo.eau, immo.service_menage,
   ium.siret, mo.type_moteur, immo.surface, immo.nombre_pieces, immo.piscine, immo.type_de_bien, immo.sanitaire,
   ium.raison_social, iu.telephone, iu.nom, iu.prenom, iu.type_user
FROM public.imo_offre iOf
left join public.imo_immobilier immo on immo.id = iOf.id
left join public.imo_mobile mo on mo.id = iOf.id
left join public.imo_users iu on iu.id= iOf.users_id
left join public.imo_user_moral ium on ium.id= iu.id;
