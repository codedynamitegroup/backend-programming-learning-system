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
  private static final long serialVersionUID = 3067987518662152355L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AnswerOfQuestion\",\"namespace\":\"com.backend.programming.learning.system.kafka.core.avro.model\",\"fields\":[{\"name\":\"answer\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"feedback\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"fraction\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

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

  private java.lang.String answer;
  private java.lang.String feedback;
  private float fraction;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AnswerOfQuestion() {}

  /**
   * All-args constructor.
   * @param answer The new value for answer
   * @param feedback The new value for feedback
   * @param fraction The new value for fraction
   */
  public AnswerOfQuestion(java.lang.String answer, java.lang.String feedback, java.lang.Float fraction) {
    this.answer = answer;
    this.feedback = feedback;
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
    case 0: return answer;
    case 1: return feedback;
    case 2: return fraction;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: answer = value$ != null ? value$.toString() : null; break;
    case 1: feedback = value$ != null ? value$.toString() : null; break;
    case 2: fraction = (java.lang.Float)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
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
   * Gets the value of the 'fraction' field.
   * @return The value of the 'fraction' field.
   */
  public float getFraction() {
    return fraction;
  }


  /**
   * Sets the value of the 'fraction' field.
   * @param value the value to set.
   */
  public void setFraction(float value) {
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

    private java.lang.String answer;
    private java.lang.String feedback;
    private float fraction;

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
      if (isValidValue(fields()[0], other.answer)) {
        this.answer = data().deepCopy(fields()[0].schema(), other.answer);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.feedback)) {
        this.feedback = data().deepCopy(fields()[1].schema(), other.feedback);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.fraction)) {
        this.fraction = data().deepCopy(fields()[2].schema(), other.fraction);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing AnswerOfQuestion instance
     * @param other The existing instance to copy.
     */
    private Builder(com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.answer)) {
        this.answer = data().deepCopy(fields()[0].schema(), other.answer);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.feedback)) {
        this.feedback = data().deepCopy(fields()[1].schema(), other.feedback);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fraction)) {
        this.fraction = data().deepCopy(fields()[2].schema(), other.fraction);
        fieldSetFlags()[2] = true;
      }
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
      validate(fields()[0], value);
      this.answer = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'answer' field has been set.
      * @return True if the 'answer' field has been set, false otherwise.
      */
    public boolean hasAnswer() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'answer' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearAnswer() {
      answer = null;
      fieldSetFlags()[0] = false;
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
      validate(fields()[1], value);
      this.feedback = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'feedback' field has been set.
      * @return True if the 'feedback' field has been set, false otherwise.
      */
    public boolean hasFeedback() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'feedback' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearFeedback() {
      feedback = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'fraction' field.
      * @return The value.
      */
    public float getFraction() {
      return fraction;
    }


    /**
      * Sets the value of the 'fraction' field.
      * @param value The value of 'fraction'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder setFraction(float value) {
      validate(fields()[2], value);
      this.fraction = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'fraction' field has been set.
      * @return True if the 'fraction' field has been set, false otherwise.
      */
    public boolean hasFraction() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'fraction' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion.Builder clearFraction() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AnswerOfQuestion build() {
      try {
        AnswerOfQuestion record = new AnswerOfQuestion();
        record.answer = fieldSetFlags()[0] ? this.answer : (java.lang.String) defaultValue(fields()[0]);
        record.feedback = fieldSetFlags()[1] ? this.feedback : (java.lang.String) defaultValue(fields()[1]);
        record.fraction = fieldSetFlags()[2] ? this.fraction : (java.lang.Float) defaultValue(fields()[2]);
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

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.answer);

    out.writeString(this.feedback);

    out.writeFloat(this.fraction);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.answer = in.readString();

      this.feedback = in.readString();

      this.fraction = in.readFloat();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.answer = in.readString();
          break;

        case 1:
          this.feedback = in.readString();
          break;

        case 2:
          this.fraction = in.readFloat();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










