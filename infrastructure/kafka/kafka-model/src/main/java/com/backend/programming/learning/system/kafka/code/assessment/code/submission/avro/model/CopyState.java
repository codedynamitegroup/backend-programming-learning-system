/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model;
@org.apache.avro.specific.AvroGenerated
public enum CopyState implements org.apache.avro.generic.GenericEnumSymbol<CopyState> {
  CREATING, CREATED, UPDATING, UPDATED, DELETING, DELETED, CREATE_PROPAGATING, UPDATE_PROPAGATING, DELETE_PROPAGATING, CREATE_ROLLBACKING, UPDATE_ROLLBACKING, DELETE_ROLLBACKING, DELETE_FAILED, UPDATE_FAILED, CREATE_FAILED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"CopyState\",\"namespace\":\"com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model\",\"symbols\":[\"CREATING\",\"CREATED\",\"UPDATING\",\"UPDATED\",\"DELETING\",\"DELETED\",\"CREATE_PROPAGATING\",\"UPDATE_PROPAGATING\",\"DELETE_PROPAGATING\",\"CREATE_ROLLBACKING\",\"UPDATE_ROLLBACKING\",\"DELETE_ROLLBACKING\",\"DELETE_FAILED\",\"UPDATE_FAILED\",\"CREATE_FAILED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
