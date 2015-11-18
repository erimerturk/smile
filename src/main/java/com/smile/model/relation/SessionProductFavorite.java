package com.smile.model.relation;

import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type = Relations.FAVORITE)
public class SessionProductFavorite extends SessionProductRelationBase {

}
