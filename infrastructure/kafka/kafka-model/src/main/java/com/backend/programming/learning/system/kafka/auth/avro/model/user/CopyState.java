/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.auth.avro.model.user;
@org.apache.avro.specific.AvroGenerated
public enum CopyState implements org.apache.avro.generic.GenericEnumSymbol<CopyState> {
  CREATING, CREATED, UPDATING, UPDATED, DELETING, DELETED, DELETE_FAILED, UPDATE_FAILED, CREATE_FAILED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"CopyState\",\"namespace\":\"com.backend.programming.learning.system.kafka.auth.avro.model.user\",\"symbols\":[\"CREATING\",\"CREATED\",\"UPDATING\",\"UPDATED\",\"DELETING\",\"DELETED\",\"DELETE_FAILED\",\"UPDATE_FAILED\",\"CREATE_FAILED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}