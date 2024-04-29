/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.auth.avro.model.organization;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class OrganizationUpdateRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4997976637538452057L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrganizationUpdateRequestAvroModel\",\"namespace\":\"com.backend.programming.learning.system.kafka.auth.avro.model.organization\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"organizationId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"description\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"name\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"email\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"phone\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"address\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"apiKey\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"moodleUrl\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"updatedAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"updatedBy\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<OrganizationUpdateRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrganizationUpdateRequestAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrganizationUpdateRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrganizationUpdateRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrganizationUpdateRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrganizationUpdateRequestAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrganizationUpdateRequestAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrganizationUpdateRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrganizationUpdateRequestAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String id;
  private String sagaId;
  private String organizationId;
  private String description;
  private String name;
  private String email;
  private String phone;
  private String address;
  private String apiKey;
  private String moodleUrl;
  private java.time.Instant updatedAt;
  private String updatedBy;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrganizationUpdateRequestAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param organizationId The new value for organizationId
   * @param description The new value for description
   * @param name The new value for name
   * @param email The new value for email
   * @param phone The new value for phone
   * @param address The new value for address
   * @param apiKey The new value for apiKey
   * @param moodleUrl The new value for moodleUrl
   * @param updatedAt The new value for updatedAt
   * @param updatedBy The new value for updatedBy
   */
  public OrganizationUpdateRequestAvroModel(String id, String sagaId, String organizationId, String description, String name, String email, String phone, String address, String apiKey, String moodleUrl, java.time.Instant updatedAt, String updatedBy) {
    this.id = id;
    this.sagaId = sagaId;
    this.organizationId = organizationId;
    this.description = description;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.apiKey = apiKey;
    this.moodleUrl = moodleUrl;
    this.updatedAt = updatedAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.updatedBy = updatedBy;
  }

  @Override
  public SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return sagaId;
    case 2: return organizationId;
    case 3: return description;
    case 4: return name;
    case 5: return email;
    case 6: return phone;
    case 7: return address;
    case 8: return apiKey;
    case 9: return moodleUrl;
    case 10: return updatedAt;
    case 11: return updatedBy;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
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
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: sagaId = value$ != null ? value$.toString() : null; break;
    case 2: organizationId = value$ != null ? value$.toString() : null; break;
    case 3: description = value$ != null ? value$.toString() : null; break;
    case 4: name = value$ != null ? value$.toString() : null; break;
    case 5: email = value$ != null ? value$.toString() : null; break;
    case 6: phone = value$ != null ? value$.toString() : null; break;
    case 7: address = value$ != null ? value$.toString() : null; break;
    case 8: apiKey = value$ != null ? value$.toString() : null; break;
    case 9: moodleUrl = value$ != null ? value$.toString() : null; break;
    case 10: updatedAt = (java.time.Instant)value$; break;
    case 11: updatedBy = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'sagaId' field.
   * @return The value of the 'sagaId' field.
   */
  public String getSagaId() {
    return sagaId;
  }


  /**
   * Sets the value of the 'sagaId' field.
   * @param value the value to set.
   */
  public void setSagaId(String value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'organizationId' field.
   * @return The value of the 'organizationId' field.
   */
  public String getOrganizationId() {
    return organizationId;
  }


  /**
   * Sets the value of the 'organizationId' field.
   * @param value the value to set.
   */
  public void setOrganizationId(String value) {
    this.organizationId = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public String getDescription() {
    return description;
  }


  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(String value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public String getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(String value) {
    this.email = value;
  }

  /**
   * Gets the value of the 'phone' field.
   * @return The value of the 'phone' field.
   */
  public String getPhone() {
    return phone;
  }


  /**
   * Sets the value of the 'phone' field.
   * @param value the value to set.
   */
  public void setPhone(String value) {
    this.phone = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return The value of the 'address' field.
   */
  public String getAddress() {
    return address;
  }


  /**
   * Sets the value of the 'address' field.
   * @param value the value to set.
   */
  public void setAddress(String value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'apiKey' field.
   * @return The value of the 'apiKey' field.
   */
  public String getApiKey() {
    return apiKey;
  }


  /**
   * Sets the value of the 'apiKey' field.
   * @param value the value to set.
   */
  public void setApiKey(String value) {
    this.apiKey = value;
  }

  /**
   * Gets the value of the 'moodleUrl' field.
   * @return The value of the 'moodleUrl' field.
   */
  public String getMoodleUrl() {
    return moodleUrl;
  }


  /**
   * Sets the value of the 'moodleUrl' field.
   * @param value the value to set.
   */
  public void setMoodleUrl(String value) {
    this.moodleUrl = value;
  }

  /**
   * Gets the value of the 'updatedAt' field.
   * @return The value of the 'updatedAt' field.
   */
  public java.time.Instant getUpdatedAt() {
    return updatedAt;
  }


  /**
   * Sets the value of the 'updatedAt' field.
   * @param value the value to set.
   */
  public void setUpdatedAt(java.time.Instant value) {
    this.updatedAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'updatedBy' field.
   * @return The value of the 'updatedBy' field.
   */
  public String getUpdatedBy() {
    return updatedBy;
  }


  /**
   * Sets the value of the 'updatedBy' field.
   * @param value the value to set.
   */
  public void setUpdatedBy(String value) {
    this.updatedBy = value;
  }

  /**
   * Creates a new OrganizationUpdateRequestAvroModel RecordBuilder.
   * @return A new OrganizationUpdateRequestAvroModel RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new OrganizationUpdateRequestAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrganizationUpdateRequestAvroModel RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new OrganizationUpdateRequestAvroModel RecordBuilder by copying an existing OrganizationUpdateRequestAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new OrganizationUpdateRequestAvroModel RecordBuilder
   */
  public static Builder newBuilder(OrganizationUpdateRequestAvroModel other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for OrganizationUpdateRequestAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrganizationUpdateRequestAvroModel>
    implements org.apache.avro.data.RecordBuilder<OrganizationUpdateRequestAvroModel> {

    private String id;
    private String sagaId;
    private String organizationId;
    private String description;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String apiKey;
    private String moodleUrl;
    private java.time.Instant updatedAt;
    private String updatedBy;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.organizationId)) {
        this.organizationId = data().deepCopy(fields()[2].schema(), other.organizationId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.description)) {
        this.description = data().deepCopy(fields()[3].schema(), other.description);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.name)) {
        this.name = data().deepCopy(fields()[4].schema(), other.name);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.email)) {
        this.email = data().deepCopy(fields()[5].schema(), other.email);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.phone)) {
        this.phone = data().deepCopy(fields()[6].schema(), other.phone);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.address)) {
        this.address = data().deepCopy(fields()[7].schema(), other.address);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.apiKey)) {
        this.apiKey = data().deepCopy(fields()[8].schema(), other.apiKey);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.moodleUrl)) {
        this.moodleUrl = data().deepCopy(fields()[9].schema(), other.moodleUrl);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.updatedAt)) {
        this.updatedAt = data().deepCopy(fields()[10].schema(), other.updatedAt);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
      if (isValidValue(fields()[11], other.updatedBy)) {
        this.updatedBy = data().deepCopy(fields()[11].schema(), other.updatedBy);
        fieldSetFlags()[11] = other.fieldSetFlags()[11];
      }
    }

    /**
     * Creates a Builder by copying an existing OrganizationUpdateRequestAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(OrganizationUpdateRequestAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.organizationId)) {
        this.organizationId = data().deepCopy(fields()[2].schema(), other.organizationId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.description)) {
        this.description = data().deepCopy(fields()[3].schema(), other.description);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.name)) {
        this.name = data().deepCopy(fields()[4].schema(), other.name);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.email)) {
        this.email = data().deepCopy(fields()[5].schema(), other.email);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.phone)) {
        this.phone = data().deepCopy(fields()[6].schema(), other.phone);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.address)) {
        this.address = data().deepCopy(fields()[7].schema(), other.address);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.apiKey)) {
        this.apiKey = data().deepCopy(fields()[8].schema(), other.apiKey);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.moodleUrl)) {
        this.moodleUrl = data().deepCopy(fields()[9].schema(), other.moodleUrl);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.updatedAt)) {
        this.updatedAt = data().deepCopy(fields()[10].schema(), other.updatedAt);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.updatedBy)) {
        this.updatedBy = data().deepCopy(fields()[11].schema(), other.updatedBy);
        fieldSetFlags()[11] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public Builder setId(String value) {
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
    public Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sagaId' field.
      * @return The value.
      */
    public String getSagaId() {
      return sagaId;
    }


    /**
      * Sets the value of the 'sagaId' field.
      * @param value The value of 'sagaId'.
      * @return This builder.
      */
    public Builder setSagaId(String value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sagaId' field has been set.
      * @return True if the 'sagaId' field has been set, false otherwise.
      */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sagaId' field.
      * @return This builder.
      */
    public Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'organizationId' field.
      * @return The value.
      */
    public String getOrganizationId() {
      return organizationId;
    }


    /**
      * Sets the value of the 'organizationId' field.
      * @param value The value of 'organizationId'.
      * @return This builder.
      */
    public Builder setOrganizationId(String value) {
      validate(fields()[2], value);
      this.organizationId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'organizationId' field has been set.
      * @return True if the 'organizationId' field has been set, false otherwise.
      */
    public boolean hasOrganizationId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'organizationId' field.
      * @return This builder.
      */
    public Builder clearOrganizationId() {
      organizationId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'description' field.
      * @return The value.
      */
    public String getDescription() {
      return description;
    }


    /**
      * Sets the value of the 'description' field.
      * @param value The value of 'description'.
      * @return This builder.
      */
    public Builder setDescription(String value) {
      validate(fields()[3], value);
      this.description = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'description' field has been set.
      * @return True if the 'description' field has been set, false otherwise.
      */
    public boolean hasDescription() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'description' field.
      * @return This builder.
      */
    public Builder clearDescription() {
      description = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public Builder setName(String value) {
      validate(fields()[4], value);
      this.name = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public Builder clearName() {
      name = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public String getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public Builder setEmail(String value) {
      validate(fields()[5], value);
      this.email = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public Builder clearEmail() {
      email = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'phone' field.
      * @return The value.
      */
    public String getPhone() {
      return phone;
    }


    /**
      * Sets the value of the 'phone' field.
      * @param value The value of 'phone'.
      * @return This builder.
      */
    public Builder setPhone(String value) {
      validate(fields()[6], value);
      this.phone = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'phone' field has been set.
      * @return True if the 'phone' field has been set, false otherwise.
      */
    public boolean hasPhone() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'phone' field.
      * @return This builder.
      */
    public Builder clearPhone() {
      phone = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * @return The value.
      */
    public String getAddress() {
      return address;
    }


    /**
      * Sets the value of the 'address' field.
      * @param value The value of 'address'.
      * @return This builder.
      */
    public Builder setAddress(String value) {
      validate(fields()[7], value);
      this.address = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'address' field has been set.
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'address' field.
      * @return This builder.
      */
    public Builder clearAddress() {
      address = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'apiKey' field.
      * @return The value.
      */
    public String getApiKey() {
      return apiKey;
    }


    /**
      * Sets the value of the 'apiKey' field.
      * @param value The value of 'apiKey'.
      * @return This builder.
      */
    public Builder setApiKey(String value) {
      validate(fields()[8], value);
      this.apiKey = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'apiKey' field has been set.
      * @return True if the 'apiKey' field has been set, false otherwise.
      */
    public boolean hasApiKey() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'apiKey' field.
      * @return This builder.
      */
    public Builder clearApiKey() {
      apiKey = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'moodleUrl' field.
      * @return The value.
      */
    public String getMoodleUrl() {
      return moodleUrl;
    }


    /**
      * Sets the value of the 'moodleUrl' field.
      * @param value The value of 'moodleUrl'.
      * @return This builder.
      */
    public Builder setMoodleUrl(String value) {
      validate(fields()[9], value);
      this.moodleUrl = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'moodleUrl' field has been set.
      * @return True if the 'moodleUrl' field has been set, false otherwise.
      */
    public boolean hasMoodleUrl() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'moodleUrl' field.
      * @return This builder.
      */
    public Builder clearMoodleUrl() {
      moodleUrl = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'updatedAt' field.
      * @return The value.
      */
    public java.time.Instant getUpdatedAt() {
      return updatedAt;
    }


    /**
      * Sets the value of the 'updatedAt' field.
      * @param value The value of 'updatedAt'.
      * @return This builder.
      */
    public Builder setUpdatedAt(java.time.Instant value) {
      validate(fields()[10], value);
      this.updatedAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'updatedAt' field has been set.
      * @return True if the 'updatedAt' field has been set, false otherwise.
      */
    public boolean hasUpdatedAt() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'updatedAt' field.
      * @return This builder.
      */
    public Builder clearUpdatedAt() {
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'updatedBy' field.
      * @return The value.
      */
    public String getUpdatedBy() {
      return updatedBy;
    }


    /**
      * Sets the value of the 'updatedBy' field.
      * @param value The value of 'updatedBy'.
      * @return This builder.
      */
    public Builder setUpdatedBy(String value) {
      validate(fields()[11], value);
      this.updatedBy = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'updatedBy' field has been set.
      * @return True if the 'updatedBy' field has been set, false otherwise.
      */
    public boolean hasUpdatedBy() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'updatedBy' field.
      * @return This builder.
      */
    public Builder clearUpdatedBy() {
      updatedBy = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrganizationUpdateRequestAvroModel build() {
      try {
        OrganizationUpdateRequestAvroModel record = new OrganizationUpdateRequestAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (String) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (String) defaultValue(fields()[1]);
        record.organizationId = fieldSetFlags()[2] ? this.organizationId : (String) defaultValue(fields()[2]);
        record.description = fieldSetFlags()[3] ? this.description : (String) defaultValue(fields()[3]);
        record.name = fieldSetFlags()[4] ? this.name : (String) defaultValue(fields()[4]);
        record.email = fieldSetFlags()[5] ? this.email : (String) defaultValue(fields()[5]);
        record.phone = fieldSetFlags()[6] ? this.phone : (String) defaultValue(fields()[6]);
        record.address = fieldSetFlags()[7] ? this.address : (String) defaultValue(fields()[7]);
        record.apiKey = fieldSetFlags()[8] ? this.apiKey : (String) defaultValue(fields()[8]);
        record.moodleUrl = fieldSetFlags()[9] ? this.moodleUrl : (String) defaultValue(fields()[9]);
        record.updatedAt = fieldSetFlags()[10] ? this.updatedAt : (java.time.Instant) defaultValue(fields()[10]);
        record.updatedBy = fieldSetFlags()[11] ? this.updatedBy : (String) defaultValue(fields()[11]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrganizationUpdateRequestAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrganizationUpdateRequestAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrganizationUpdateRequestAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<OrganizationUpdateRequestAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










