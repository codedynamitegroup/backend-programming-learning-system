/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.core.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AnswerOfQuestion extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2113224482327661323L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AnswerOfQuestion\",\"namespace\":\"com.backend.programming.learning.system.kafka.core.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"questionId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"feedback\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"answer\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"fraction\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\",\"java-class\":\"java.math.BigDecimal\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
  }

  private static final BinaryMessageEncoder<AnswerOfQuestion> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AnswerOfQuestion> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AnswerOfQuestion> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AnswerOfQuestion> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AnswerOfQuestion> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AnswerOfQuestion to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AnswerOfQuestion from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AnswerOfQuestion instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AnswerOfQuestion fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID id;
  private java.util.UUID questionId;
  private java.lang.String feedback;
  private java.lang.String answer;
  private java.math.BigDecimal fraction;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AnswerOfQuestion() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param questionId The new value for questionId
   * @param feedback The new value for feedback
   * @param answer The new value for answer
   * @param fraction The new value for fraction
   */
  public AnswerOfQuestion(java.util.UUID id, java.util.UUID questionId, java.lang.String feedback, java.lang.String answer, java.math.BigDecimal fraction) {
    this.id = id;
    this.questionId = questionId;
    this.feedback = feedback;
    this.answer = answer;
    this.fraction = fraction;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return questionId;
    case 2: return feedback;
    case 3: return answer;
    case 4: return fraction;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      null,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.util.UUID)value$; break;
    case 1: questionId = (java.util.UUID)value$; break;
    case 2: feedback = value$ != null ? value$.toString() : null; break;
    case 3: answer = value$ != null ? value$.toString() : null; break;
    case 4: fraction = (java.math.BigDecimal)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.util.UUID getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.util.UUID value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'questionId' field.
   * @return The value of the 'questionId' field.
   */
  public java.util.UUID getQuestionId() {
    return questionId;
  }


  /**
   * Sets the value of the 'questionId' field.
   * @param value the value to set.
   */
  public void setQuestionId(java.util.UUID value) {
    this.questionId = value;
  }

  /**
   * Gets the value of the 'feedback' field.
   * @return The value of the 'feedback' field.
   */
  public java.lang.String getFeedback() {
    return feedback;
  }


  /**
   * Sets the value of the 'feedback' field.
   * @param value the value to set.
   */
  public void setFeedback(java.lang.String value) {
    this.feedback = value;
  }

  /**
   * Gets the value of the 'answer' field.
   * @return The value of the 'answer' field.
   */
  public java.lang.String getAnswer() {
    return answer;
  }


  /**
   * Sets the value of the 'answer' field.
   * @param value the value to set.
   */
  public void setAnswer(java.lang.String value) {
    this.answer = value;
  }

  /**
   * Gets the value of the 'fraction' field.
   * @return The value of the 'fraction' field.
   */
  public java.math.BigDecimal getFraction() {
    return fraction;
  }


  /**
   * Sets the value of the 'fraction' field.
   * @param value the value to set.
   */
  public void setFraction(java.math.BigDecimal value) {
    this.fraction = value;
  }

  /**
   * Creates a new AnswerOfQuestion RecordBuilder.
   * @return A new AnswerOfQuestion RecordBuilder
   */
  public static com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder newBuilder() {
    return new com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder();
  }

  /**
   * Creates a new AnswerOfQuestion RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AnswerOfQuestion RecordBuilder
   */
  public static com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder newBuilder(com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder other) {
    if (other == null) {
      return new com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder();
    } else {
      return new com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder(other);
    }
  }

  /**
   * Creates a new AnswerOfQuestion RecordBuilder by copying an existing AnswerOfQuestion instance.
   * @param other The existing instance to copy.
   * @return A new AnswerOfQuestion RecordBuilder
   */
  public static com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder newBuilder(com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion other) {
    if (other == null) {
      return new com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder();
    } else {
      return new com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder(other);
    }
  }

  /**
   * RecordBuilder for AnswerOfQuestion instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AnswerOfQuestion>
    implements org.apache.avro.data.RecordBuilder<AnswerOfQuestion> {

    private java.util.UUID id;
    private java.util.UUID questionId;
    private java.lang.String feedback;
    private java.lang.String answer;
    private java.math.BigDecimal fraction;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.questionId)) {
        this.questionId = data().deepCopy(fields()[1].schema(), other.questionId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.feedback)) {
        this.feedback = data().deepCopy(fields()[2].schema(), other.feedback);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.answer)) {
        this.answer = data().deepCopy(fields()[3].schema(), other.answer);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.fraction)) {
        this.fraction = data().deepCopy(fields()[4].schema(), other.fraction);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing AnswerOfQuestion instance
     * @param other The existing instance to copy.
     */
    private Builder(com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.questionId)) {
        this.questionId = data().deepCopy(fields()[1].schema(), other.questionId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.feedback)) {
        this.feedback = data().deepCopy(fields()[2].schema(), other.feedback);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.answer)) {
        this.answer = data().deepCopy(fields()[3].schema(), other.answer);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.fraction)) {
        this.fraction = data().deepCopy(fields()[4].schema(), other.fraction);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.util.UUID getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder setId(java.util.UUID value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'questionId' field.
      * @return The value.
      */
    public java.util.UUID getQuestionId() {
      return questionId;
    }


    /**
      * Sets the value of the 'questionId' field.
      * @param value The value of 'questionId'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder setQuestionId(java.util.UUID value) {
      validate(fields()[1], value);
      this.questionId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'questionId' field has been set.
      * @return True if the 'questionId' field has been set, false otherwise.
      */
    public boolean hasQuestionId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'questionId' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearQuestionId() {
      questionId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'feedback' field.
      * @return The value.
      */
    public java.lang.String getFeedback() {
      return feedback;
    }


    /**
      * Sets the value of the 'feedback' field.
      * @param value The value of 'feedback'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder setFeedback(java.lang.String value) {
      validate(fields()[2], value);
      this.feedback = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'feedback' field has been set.
      * @return True if the 'feedback' field has been set, false otherwise.
      */
    public boolean hasFeedback() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'feedback' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearFeedback() {
      feedback = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'answer' field.
      * @return The value.
      */
    public java.lang.String getAnswer() {
      return answer;
    }


    /**
      * Sets the value of the 'answer' field.
      * @param value The value of 'answer'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder setAnswer(java.lang.String value) {
      validate(fields()[3], value);
      this.answer = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'answer' field has been set.
      * @return True if the 'answer' field has been set, false otherwise.
      */
    public boolean hasAnswer() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'answer' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearAnswer() {
      answer = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'fraction' field.
      * @return The value.
      */
    public java.math.BigDecimal getFraction() {
      return fraction;
    }


    /**
      * Sets the value of the 'fraction' field.
      * @param value The value of 'fraction'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder setFraction(java.math.BigDecimal value) {
      validate(fields()[4], value);
      this.fraction = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'fraction' field has been set.
      * @return True if the 'fraction' field has been set, false otherwise.
      */
    public boolean hasFraction() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'fraction' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearFraction() {
      fraction = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AnswerOfQuestion build() {
      try {
        AnswerOfQuestion record = new AnswerOfQuestion();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.questionId = fieldSetFlags()[1] ? this.questionId : (java.util.UUID) defaultValue(fields()[1]);
        record.feedback = fieldSetFlags()[2] ? this.feedback : (java.lang.String) defaultValue(fields()[2]);
        record.answer = fieldSetFlags()[3] ? this.answer : (java.lang.String) defaultValue(fields()[3]);
        record.fraction = fieldSetFlags()[4] ? this.fraction : (java.math.BigDecimal) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AnswerOfQuestion>
    WRITER$ = (org.apache.avro.io.DatumWriter<AnswerOfQuestion>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AnswerOfQuestion>
    READER$ = (org.apache.avro.io.DatumReader<AnswerOfQuestion>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










