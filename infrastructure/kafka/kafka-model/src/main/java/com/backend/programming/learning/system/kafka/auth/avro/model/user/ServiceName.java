/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.auth.avro.model.user;
@org.apache.avro.specific.AvroGenerated
public enum ServiceName implements org.apache.avro.generic.GenericEnumSymbol<ServiceName> {
  CORE_SERVICE, AUTH_SERVICE, COURSE_SERVICE, CODE_ASSESSMENT_SERVICE, BACKGROUND_SERVICE  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"ServiceName\",\"namespace\":\"com.backend.programming.learning.system.kafka.auth.avro.model.user\",\"symbols\":[\"CORE_SERVICE\",\"AUTH_SERVICE\",\"COURSE_SERVICE\",\"CODE_ASSESSMENT_SERVICE\",\"BACKGROUND_SERVICE\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
