/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.amitsoni.avro.udemy;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Review extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4224770788377641207L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Review\",\"namespace\":\"com.github.amitsoni.avro.udemy\",\"fields\":[{\"name\":\"id\",\"type\":\"long\",\"doc\":\"Review ID as per Udemy's db\"},{\"name\":\"title\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"content\",\"type\":[\"null\",\"string\"],\"doc\":\"Review text if provided\",\"default\":null},{\"name\":\"rating\",\"type\":\"string\",\"doc\":\"review value\"},{\"name\":\"created\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"modified\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"user\",\"type\":{\"type\":\"record\",\"name\":\"User\",\"fields\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"first name\"},{\"name\":\"display_name\",\"type\":\"string\"}]}},{\"name\":\"course\",\"type\":{\"type\":\"record\",\"name\":\"Course\",\"fields\":[{\"name\":\"id\",\"type\":\"long\",\"doc\":\"Course ID in Udemy's DB\"},{\"name\":\"title\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"url\",\"type\":[\"null\",\"string\"],\"default\":null}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Review> ENCODER =
      new BinaryMessageEncoder<Review>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Review> DECODER =
      new BinaryMessageDecoder<Review>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Review> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Review> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Review>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Review to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Review from a ByteBuffer. */
  public static Review fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Review ID as per Udemy's db */
  @Deprecated public long id;
  @Deprecated public java.lang.CharSequence title;
  /** Review text if provided */
  @Deprecated public java.lang.CharSequence content;
  /** review value */
  @Deprecated public java.lang.CharSequence rating;
  @Deprecated public org.joda.time.DateTime created;
  @Deprecated public org.joda.time.DateTime modified;
  @Deprecated public com.github.amitsoni.avro.udemy.User user;
  @Deprecated public com.github.amitsoni.avro.udemy.Course course;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Review() {}

  /**
   * All-args constructor.
   * @param id Review ID as per Udemy's db
   * @param title The new value for title
   * @param content Review text if provided
   * @param rating review value
   * @param created The new value for created
   * @param modified The new value for modified
   * @param user The new value for user
   * @param course The new value for course
   */
  public Review(java.lang.Long id, java.lang.CharSequence title, java.lang.CharSequence content, java.lang.CharSequence rating, org.joda.time.DateTime created, org.joda.time.DateTime modified, com.github.amitsoni.avro.udemy.User user, com.github.amitsoni.avro.udemy.Course course) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.rating = rating;
    this.created = created;
    this.modified = modified;
    this.user = user;
    this.course = course;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return title;
    case 2: return content;
    case 3: return rating;
    case 4: return created;
    case 5: return modified;
    case 6: return user;
    case 7: return course;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();
  protected static final org.apache.avro.Conversions.DecimalConversion DECIMAL_CONVERSION = new org.apache.avro.Conversions.DecimalConversion();

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      TIMESTAMP_CONVERSION,
      TIMESTAMP_CONVERSION,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: title = (java.lang.CharSequence)value$; break;
    case 2: content = (java.lang.CharSequence)value$; break;
    case 3: rating = (java.lang.CharSequence)value$; break;
    case 4: created = (org.joda.time.DateTime)value$; break;
    case 5: modified = (org.joda.time.DateTime)value$; break;
    case 6: user = (com.github.amitsoni.avro.udemy.User)value$; break;
    case 7: course = (com.github.amitsoni.avro.udemy.Course)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return Review ID as per Udemy's db
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * Review ID as per Udemy's db
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }

  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'content' field.
   * @return Review text if provided
   */
  public java.lang.CharSequence getContent() {
    return content;
  }

  /**
   * Sets the value of the 'content' field.
   * Review text if provided
   * @param value the value to set.
   */
  public void setContent(java.lang.CharSequence value) {
    this.content = value;
  }

  /**
   * Gets the value of the 'rating' field.
   * @return review value
   */
  public java.lang.CharSequence getRating() {
    return rating;
  }

  /**
   * Sets the value of the 'rating' field.
   * review value
   * @param value the value to set.
   */
  public void setRating(java.lang.CharSequence value) {
    this.rating = value;
  }

  /**
   * Gets the value of the 'created' field.
   * @return The value of the 'created' field.
   */
  public org.joda.time.DateTime getCreated() {
    return created;
  }

  /**
   * Sets the value of the 'created' field.
   * @param value the value to set.
   */
  public void setCreated(org.joda.time.DateTime value) {
    this.created = value;
  }

  /**
   * Gets the value of the 'modified' field.
   * @return The value of the 'modified' field.
   */
  public org.joda.time.DateTime getModified() {
    return modified;
  }

  /**
   * Sets the value of the 'modified' field.
   * @param value the value to set.
   */
  public void setModified(org.joda.time.DateTime value) {
    this.modified = value;
  }

  /**
   * Gets the value of the 'user' field.
   * @return The value of the 'user' field.
   */
  public com.github.amitsoni.avro.udemy.User getUser() {
    return user;
  }

  /**
   * Sets the value of the 'user' field.
   * @param value the value to set.
   */
  public void setUser(com.github.amitsoni.avro.udemy.User value) {
    this.user = value;
  }

  /**
   * Gets the value of the 'course' field.
   * @return The value of the 'course' field.
   */
  public com.github.amitsoni.avro.udemy.Course getCourse() {
    return course;
  }

  /**
   * Sets the value of the 'course' field.
   * @param value the value to set.
   */
  public void setCourse(com.github.amitsoni.avro.udemy.Course value) {
    this.course = value;
  }

  /**
   * Creates a new Review RecordBuilder.
   * @return A new Review RecordBuilder
   */
  public static com.github.amitsoni.avro.udemy.Review.Builder newBuilder() {
    return new com.github.amitsoni.avro.udemy.Review.Builder();
  }

  /**
   * Creates a new Review RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Review RecordBuilder
   */
  public static com.github.amitsoni.avro.udemy.Review.Builder newBuilder(com.github.amitsoni.avro.udemy.Review.Builder other) {
    return new com.github.amitsoni.avro.udemy.Review.Builder(other);
  }

  /**
   * Creates a new Review RecordBuilder by copying an existing Review instance.
   * @param other The existing instance to copy.
   * @return A new Review RecordBuilder
   */
  public static com.github.amitsoni.avro.udemy.Review.Builder newBuilder(com.github.amitsoni.avro.udemy.Review other) {
    return new com.github.amitsoni.avro.udemy.Review.Builder(other);
  }

  /**
   * RecordBuilder for Review instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Review>
    implements org.apache.avro.data.RecordBuilder<Review> {

    /** Review ID as per Udemy's db */
    private long id;
    private java.lang.CharSequence title;
    /** Review text if provided */
    private java.lang.CharSequence content;
    /** review value */
    private java.lang.CharSequence rating;
    private org.joda.time.DateTime created;
    private org.joda.time.DateTime modified;
    private com.github.amitsoni.avro.udemy.User user;
    private com.github.amitsoni.avro.udemy.User.Builder userBuilder;
    private com.github.amitsoni.avro.udemy.Course course;
    private com.github.amitsoni.avro.udemy.Course.Builder courseBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.amitsoni.avro.udemy.Review.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.title)) {
        this.title = data().deepCopy(fields()[1].schema(), other.title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.content)) {
        this.content = data().deepCopy(fields()[2].schema(), other.content);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.rating)) {
        this.rating = data().deepCopy(fields()[3].schema(), other.rating);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.created)) {
        this.created = data().deepCopy(fields()[4].schema(), other.created);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.modified)) {
        this.modified = data().deepCopy(fields()[5].schema(), other.modified);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.user)) {
        this.user = data().deepCopy(fields()[6].schema(), other.user);
        fieldSetFlags()[6] = true;
      }
      if (other.hasUserBuilder()) {
        this.userBuilder = com.github.amitsoni.avro.udemy.User.newBuilder(other.getUserBuilder());
      }
      if (isValidValue(fields()[7], other.course)) {
        this.course = data().deepCopy(fields()[7].schema(), other.course);
        fieldSetFlags()[7] = true;
      }
      if (other.hasCourseBuilder()) {
        this.courseBuilder = com.github.amitsoni.avro.udemy.Course.newBuilder(other.getCourseBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing Review instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.amitsoni.avro.udemy.Review other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.title)) {
        this.title = data().deepCopy(fields()[1].schema(), other.title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.content)) {
        this.content = data().deepCopy(fields()[2].schema(), other.content);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.rating)) {
        this.rating = data().deepCopy(fields()[3].schema(), other.rating);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.created)) {
        this.created = data().deepCopy(fields()[4].schema(), other.created);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.modified)) {
        this.modified = data().deepCopy(fields()[5].schema(), other.modified);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.user)) {
        this.user = data().deepCopy(fields()[6].schema(), other.user);
        fieldSetFlags()[6] = true;
      }
      this.userBuilder = null;
      if (isValidValue(fields()[7], other.course)) {
        this.course = data().deepCopy(fields()[7].schema(), other.course);
        fieldSetFlags()[7] = true;
      }
      this.courseBuilder = null;
    }

    /**
      * Gets the value of the 'id' field.
      * Review ID as per Udemy's db
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * Review ID as per Udemy's db
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * Review ID as per Udemy's db
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * Review ID as per Udemy's db
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public java.lang.CharSequence getTitle() {
      return title;
    }

    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.title = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearTitle() {
      title = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'content' field.
      * Review text if provided
      * @return The value.
      */
    public java.lang.CharSequence getContent() {
      return content;
    }

    /**
      * Sets the value of the 'content' field.
      * Review text if provided
      * @param value The value of 'content'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setContent(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.content = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'content' field has been set.
      * Review text if provided
      * @return True if the 'content' field has been set, false otherwise.
      */
    public boolean hasContent() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'content' field.
      * Review text if provided
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearContent() {
      content = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'rating' field.
      * review value
      * @return The value.
      */
    public java.lang.CharSequence getRating() {
      return rating;
    }

    /**
      * Sets the value of the 'rating' field.
      * review value
      * @param value The value of 'rating'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setRating(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.rating = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'rating' field has been set.
      * review value
      * @return True if the 'rating' field has been set, false otherwise.
      */
    public boolean hasRating() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'rating' field.
      * review value
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearRating() {
      rating = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'created' field.
      * @return The value.
      */
    public org.joda.time.DateTime getCreated() {
      return created;
    }

    /**
      * Sets the value of the 'created' field.
      * @param value The value of 'created'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setCreated(org.joda.time.DateTime value) {
      validate(fields()[4], value);
      this.created = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'created' field has been set.
      * @return True if the 'created' field has been set, false otherwise.
      */
    public boolean hasCreated() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'created' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearCreated() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'modified' field.
      * @return The value.
      */
    public org.joda.time.DateTime getModified() {
      return modified;
    }

    /**
      * Sets the value of the 'modified' field.
      * @param value The value of 'modified'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setModified(org.joda.time.DateTime value) {
      validate(fields()[5], value);
      this.modified = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'modified' field has been set.
      * @return True if the 'modified' field has been set, false otherwise.
      */
    public boolean hasModified() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'modified' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearModified() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'user' field.
      * @return The value.
      */
    public com.github.amitsoni.avro.udemy.User getUser() {
      return user;
    }

    /**
      * Sets the value of the 'user' field.
      * @param value The value of 'user'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setUser(com.github.amitsoni.avro.udemy.User value) {
      validate(fields()[6], value);
      this.userBuilder = null;
      this.user = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'user' field has been set.
      * @return True if the 'user' field has been set, false otherwise.
      */
    public boolean hasUser() {
      return fieldSetFlags()[6];
    }

    /**
     * Gets the Builder instance for the 'user' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.github.amitsoni.avro.udemy.User.Builder getUserBuilder() {
      if (userBuilder == null) {
        if (hasUser()) {
          setUserBuilder(com.github.amitsoni.avro.udemy.User.newBuilder(user));
        } else {
          setUserBuilder(com.github.amitsoni.avro.udemy.User.newBuilder());
        }
      }
      return userBuilder;
    }

    /**
     * Sets the Builder instance for the 'user' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.github.amitsoni.avro.udemy.Review.Builder setUserBuilder(com.github.amitsoni.avro.udemy.User.Builder value) {
      clearUser();
      userBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'user' field has an active Builder instance
     * @return True if the 'user' field has an active Builder instance
     */
    public boolean hasUserBuilder() {
      return userBuilder != null;
    }

    /**
      * Clears the value of the 'user' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearUser() {
      user = null;
      userBuilder = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'course' field.
      * @return The value.
      */
    public com.github.amitsoni.avro.udemy.Course getCourse() {
      return course;
    }

    /**
      * Sets the value of the 'course' field.
      * @param value The value of 'course'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder setCourse(com.github.amitsoni.avro.udemy.Course value) {
      validate(fields()[7], value);
      this.courseBuilder = null;
      this.course = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'course' field has been set.
      * @return True if the 'course' field has been set, false otherwise.
      */
    public boolean hasCourse() {
      return fieldSetFlags()[7];
    }

    /**
     * Gets the Builder instance for the 'course' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.github.amitsoni.avro.udemy.Course.Builder getCourseBuilder() {
      if (courseBuilder == null) {
        if (hasCourse()) {
          setCourseBuilder(com.github.amitsoni.avro.udemy.Course.newBuilder(course));
        } else {
          setCourseBuilder(com.github.amitsoni.avro.udemy.Course.newBuilder());
        }
      }
      return courseBuilder;
    }

    /**
     * Sets the Builder instance for the 'course' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.github.amitsoni.avro.udemy.Review.Builder setCourseBuilder(com.github.amitsoni.avro.udemy.Course.Builder value) {
      clearCourse();
      courseBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'course' field has an active Builder instance
     * @return True if the 'course' field has an active Builder instance
     */
    public boolean hasCourseBuilder() {
      return courseBuilder != null;
    }

    /**
      * Clears the value of the 'course' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.Review.Builder clearCourse() {
      course = null;
      courseBuilder = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Review build() {
      try {
        Review record = new Review();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0], record.getConversion(0));
        record.title = fieldSetFlags()[1] ? this.title : (java.lang.CharSequence) defaultValue(fields()[1], record.getConversion(1));
        record.content = fieldSetFlags()[2] ? this.content : (java.lang.CharSequence) defaultValue(fields()[2], record.getConversion(2));
        record.rating = fieldSetFlags()[3] ? this.rating : (java.lang.CharSequence) defaultValue(fields()[3], record.getConversion(3));
        record.created = fieldSetFlags()[4] ? this.created : (org.joda.time.DateTime) defaultValue(fields()[4], record.getConversion(4));
        record.modified = fieldSetFlags()[5] ? this.modified : (org.joda.time.DateTime) defaultValue(fields()[5], record.getConversion(5));
        if (userBuilder != null) {
          record.user = this.userBuilder.build();
        } else {
          record.user = fieldSetFlags()[6] ? this.user : (com.github.amitsoni.avro.udemy.User) defaultValue(fields()[6], record.getConversion(6));
        }
        if (courseBuilder != null) {
          record.course = this.courseBuilder.build();
        } else {
          record.course = fieldSetFlags()[7] ? this.course : (com.github.amitsoni.avro.udemy.Course) defaultValue(fields()[7], record.getConversion(7));
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Review>
    WRITER$ = (org.apache.avro.io.DatumWriter<Review>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Review>
    READER$ = (org.apache.avro.io.DatumReader<Review>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
