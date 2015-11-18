package com.smile.model.relation;

import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type = Relations.CLICKED)
public class SessionProductClick extends SessionProductRelationBase {

}
