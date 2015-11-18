package com.smile.model.relation;

import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type = Relations.ORDERED)
public class SessionProductOrder extends SessionProductRelationBase {

}
