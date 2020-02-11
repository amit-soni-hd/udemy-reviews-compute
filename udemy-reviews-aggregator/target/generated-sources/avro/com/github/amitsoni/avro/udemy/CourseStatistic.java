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
public class CourseStatistic extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7124954576431533258L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CourseStatistic\",\"namespace\":\"com.github.amitsoni.avro.udemy\",\"fields\":[{\"name\":\"course_id\",\"type\":\"long\",\"doc\":\"Course ID in Udemy's DB\",\"default\":-1},{\"name\":\"course_title\",\"type\":\"string\",\"doc\":\"Course Title\",\"default\":\"\"},{\"name\":\"average_rating\",\"type\":\"double\",\"default\":0},{\"name\":\"count_reviews\",\"type\":\"long\",\"default\":0},{\"name\":\"count_five_stars\",\"type\":\"long\",\"default\":0},{\"name\":\"count_four_stars\",\"type\":\"long\",\"default\":0},{\"name\":\"count_three_stars\",\"type\":\"long\",\"default\":0},{\"name\":\"count_two_stars\",\"type\":\"long\",\"default\":0},{\"name\":\"count_one_star\",\"type\":\"long\",\"default\":0},{\"name\":\"count_zero_star\",\"type\":\"long\",\"default\":0},{\"name\":\"last_review_time\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"},\"doc\":\"last review in aggregation\"},{\"name\":\"sum_rating\",\"type\":\"double\",\"default\":0}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CourseStatistic> ENCODER =
      new BinaryMessageEncoder<CourseStatistic>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CourseStatistic> DECODER =
      new BinaryMessageDecoder<CourseStatistic>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<CourseStatistic> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<CourseStatistic> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CourseStatistic>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this CourseStatistic to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a CourseStatistic from a ByteBuffer. */
  public static CourseStatistic fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Course ID in Udemy's DB */
  @Deprecated public long course_id;
  /** Course Title */
  @Deprecated public java.lang.CharSequence course_title;
  @Deprecated public double average_rating;
  @Deprecated public long count_reviews;
  @Deprecated public long count_five_stars;
  @Deprecated public long count_four_stars;
  @Deprecated public long count_three_stars;
  @Deprecated public long count_two_stars;
  @Deprecated public long count_one_star;
  @Deprecated public long count_zero_star;
  /** last review in aggregation */
  @Deprecated public org.joda.time.DateTime last_review_time;
  @Deprecated public double sum_rating;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CourseStatistic() {}

  /**
   * All-args constructor.
   * @param course_id Course ID in Udemy's DB
   * @param course_title Course Title
   * @param average_rating The new value for average_rating
   * @param count_reviews The new value for count_reviews
   * @param count_five_stars The new value for count_five_stars
   * @param count_four_stars The new value for count_four_stars
   * @param count_three_stars The new value for count_three_stars
   * @param count_two_stars The new value for count_two_stars
   * @param count_one_star The new value for count_one_star
   * @param count_zero_star The new value for count_zero_star
   * @param last_review_time last review in aggregation
   * @param sum_rating The new value for sum_rating
   */
  public CourseStatistic(java.lang.Long course_id, java.lang.CharSequence course_title, java.lang.Double average_rating, java.lang.Long count_reviews, java.lang.Long count_five_stars, java.lang.Long count_four_stars, java.lang.Long count_three_stars, java.lang.Long count_two_stars, java.lang.Long count_one_star, java.lang.Long count_zero_star, org.joda.time.DateTime last_review_time, java.lang.Double sum_rating) {
    this.course_id = course_id;
    this.course_title = course_title;
    this.average_rating = average_rating;
    this.count_reviews = count_reviews;
    this.count_five_stars = count_five_stars;
    this.count_four_stars = count_four_stars;
    this.count_three_stars = count_three_stars;
    this.count_two_stars = count_two_stars;
    this.count_one_star = count_one_star;
    this.count_zero_star = count_zero_star;
    this.last_review_time = last_review_time;
    this.sum_rating = sum_rating;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return course_id;
    case 1: return course_title;
    case 2: return average_rating;
    case 3: return count_reviews;
    case 4: return count_five_stars;
    case 5: return count_four_stars;
    case 6: return count_three_stars;
    case 7: return count_two_stars;
    case 8: return count_one_star;
    case 9: return count_zero_star;
    case 10: return last_review_time;
    case 11: return sum_rating;
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
      null,
      null,
      null,
      null,
      null,
      null,
      TIMESTAMP_CONVERSION,
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
    case 0: course_id = (java.lang.Long)value$; break;
    case 1: course_title = (java.lang.CharSequence)value$; break;
    case 2: average_rating = (java.lang.Double)value$; break;
    case 3: count_reviews = (java.lang.Long)value$; break;
    case 4: count_five_stars = (java.lang.Long)value$; break;
    case 5: count_four_stars = (java.lang.Long)value$; break;
    case 6: count_three_stars = (java.lang.Long)value$; break;
    case 7: count_two_stars = (java.lang.Long)value$; break;
    case 8: count_one_star = (java.lang.Long)value$; break;
    case 9: count_zero_star = (java.lang.Long)value$; break;
    case 10: last_review_time = (org.joda.time.DateTime)value$; break;
    case 11: sum_rating = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'course_id' field.
   * @return Course ID in Udemy's DB
   */
  public java.lang.Long getCourseId() {
    return course_id;
  }

  /**
   * Sets the value of the 'course_id' field.
   * Course ID in Udemy's DB
   * @param value the value to set.
   */
  public void setCourseId(java.lang.Long value) {
    this.course_id = value;
  }

  /**
   * Gets the value of the 'course_title' field.
   * @return Course Title
   */
  public java.lang.CharSequence getCourseTitle() {
    return course_title;
  }

  /**
   * Sets the value of the 'course_title' field.
   * Course Title
   * @param value the value to set.
   */
  public void setCourseTitle(java.lang.CharSequence value) {
    this.course_title = value;
  }

  /**
   * Gets the value of the 'average_rating' field.
   * @return The value of the 'average_rating' field.
   */
  public java.lang.Double getAverageRating() {
    return average_rating;
  }

  /**
   * Sets the value of the 'average_rating' field.
   * @param value the value to set.
   */
  public void setAverageRating(java.lang.Double value) {
    this.average_rating = value;
  }

  /**
   * Gets the value of the 'count_reviews' field.
   * @return The value of the 'count_reviews' field.
   */
  public java.lang.Long getCountReviews() {
    return count_reviews;
  }

  /**
   * Sets the value of the 'count_reviews' field.
   * @param value the value to set.
   */
  public void setCountReviews(java.lang.Long value) {
    this.count_reviews = value;
  }

  /**
   * Gets the value of the 'count_five_stars' field.
   * @return The value of the 'count_five_stars' field.
   */
  public java.lang.Long getCountFiveStars() {
    return count_five_stars;
  }

  /**
   * Sets the value of the 'count_five_stars' field.
   * @param value the value to set.
   */
  public void setCountFiveStars(java.lang.Long value) {
    this.count_five_stars = value;
  }

  /**
   * Gets the value of the 'count_four_stars' field.
   * @return The value of the 'count_four_stars' field.
   */
  public java.lang.Long getCountFourStars() {
    return count_four_stars;
  }

  /**
   * Sets the value of the 'count_four_stars' field.
   * @param value the value to set.
   */
  public void setCountFourStars(java.lang.Long value) {
    this.count_four_stars = value;
  }

  /**
   * Gets the value of the 'count_three_stars' field.
   * @return The value of the 'count_three_stars' field.
   */
  public java.lang.Long getCountThreeStars() {
    return count_three_stars;
  }

  /**
   * Sets the value of the 'count_three_stars' field.
   * @param value the value to set.
   */
  public void setCountThreeStars(java.lang.Long value) {
    this.count_three_stars = value;
  }

  /**
   * Gets the value of the 'count_two_stars' field.
   * @return The value of the 'count_two_stars' field.
   */
  public java.lang.Long getCountTwoStars() {
    return count_two_stars;
  }

  /**
   * Sets the value of the 'count_two_stars' field.
   * @param value the value to set.
   */
  public void setCountTwoStars(java.lang.Long value) {
    this.count_two_stars = value;
  }

  /**
   * Gets the value of the 'count_one_star' field.
   * @return The value of the 'count_one_star' field.
   */
  public java.lang.Long getCountOneStar() {
    return count_one_star;
  }

  /**
   * Sets the value of the 'count_one_star' field.
   * @param value the value to set.
   */
  public void setCountOneStar(java.lang.Long value) {
    this.count_one_star = value;
  }

  /**
   * Gets the value of the 'count_zero_star' field.
   * @return The value of the 'count_zero_star' field.
   */
  public java.lang.Long getCountZeroStar() {
    return count_zero_star;
  }

  /**
   * Sets the value of the 'count_zero_star' field.
   * @param value the value to set.
   */
  public void setCountZeroStar(java.lang.Long value) {
    this.count_zero_star = value;
  }

  /**
   * Gets the value of the 'last_review_time' field.
   * @return last review in aggregation
   */
  public org.joda.time.DateTime getLastReviewTime() {
    return last_review_time;
  }

  /**
   * Sets the value of the 'last_review_time' field.
   * last review in aggregation
   * @param value the value to set.
   */
  public void setLastReviewTime(org.joda.time.DateTime value) {
    this.last_review_time = value;
  }

  /**
   * Gets the value of the 'sum_rating' field.
   * @return The value of the 'sum_rating' field.
   */
  public java.lang.Double getSumRating() {
    return sum_rating;
  }

  /**
   * Sets the value of the 'sum_rating' field.
   * @param value the value to set.
   */
  public void setSumRating(java.lang.Double value) {
    this.sum_rating = value;
  }

  /**
   * Creates a new CourseStatistic RecordBuilder.
   * @return A new CourseStatistic RecordBuilder
   */
  public static com.github.amitsoni.avro.udemy.CourseStatistic.Builder newBuilder() {
    return new com.github.amitsoni.avro.udemy.CourseStatistic.Builder();
  }

  /**
   * Creates a new CourseStatistic RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CourseStatistic RecordBuilder
   */
  public static com.github.amitsoni.avro.udemy.CourseStatistic.Builder newBuilder(com.github.amitsoni.avro.udemy.CourseStatistic.Builder other) {
    return new com.github.amitsoni.avro.udemy.CourseStatistic.Builder(other);
  }

  /**
   * Creates a new CourseStatistic RecordBuilder by copying an existing CourseStatistic instance.
   * @param other The existing instance to copy.
   * @return A new CourseStatistic RecordBuilder
   */
  public static com.github.amitsoni.avro.udemy.CourseStatistic.Builder newBuilder(com.github.amitsoni.avro.udemy.CourseStatistic other) {
    return new com.github.amitsoni.avro.udemy.CourseStatistic.Builder(other);
  }

  /**
   * RecordBuilder for CourseStatistic instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CourseStatistic>
    implements org.apache.avro.data.RecordBuilder<CourseStatistic> {

    /** Course ID in Udemy's DB */
    private long course_id;
    /** Course Title */
    private java.lang.CharSequence course_title;
    private double average_rating;
    private long count_reviews;
    private long count_five_stars;
    private long count_four_stars;
    private long count_three_stars;
    private long count_two_stars;
    private long count_one_star;
    private long count_zero_star;
    /** last review in aggregation */
    private org.joda.time.DateTime last_review_time;
    private double sum_rating;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.amitsoni.avro.udemy.CourseStatistic.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.course_id)) {
        this.course_id = data().deepCopy(fields()[0].schema(), other.course_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.course_title)) {
        this.course_title = data().deepCopy(fields()[1].schema(), other.course_title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.average_rating)) {
        this.average_rating = data().deepCopy(fields()[2].schema(), other.average_rating);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.count_reviews)) {
        this.count_reviews = data().deepCopy(fields()[3].schema(), other.count_reviews);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.count_five_stars)) {
        this.count_five_stars = data().deepCopy(fields()[4].schema(), other.count_five_stars);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.count_four_stars)) {
        this.count_four_stars = data().deepCopy(fields()[5].schema(), other.count_four_stars);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.count_three_stars)) {
        this.count_three_stars = data().deepCopy(fields()[6].schema(), other.count_three_stars);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.count_two_stars)) {
        this.count_two_stars = data().deepCopy(fields()[7].schema(), other.count_two_stars);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.count_one_star)) {
        this.count_one_star = data().deepCopy(fields()[8].schema(), other.count_one_star);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.count_zero_star)) {
        this.count_zero_star = data().deepCopy(fields()[9].schema(), other.count_zero_star);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.last_review_time)) {
        this.last_review_time = data().deepCopy(fields()[10].schema(), other.last_review_time);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.sum_rating)) {
        this.sum_rating = data().deepCopy(fields()[11].schema(), other.sum_rating);
        fieldSetFlags()[11] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing CourseStatistic instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.amitsoni.avro.udemy.CourseStatistic other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.course_id)) {
        this.course_id = data().deepCopy(fields()[0].schema(), other.course_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.course_title)) {
        this.course_title = data().deepCopy(fields()[1].schema(), other.course_title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.average_rating)) {
        this.average_rating = data().deepCopy(fields()[2].schema(), other.average_rating);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.count_reviews)) {
        this.count_reviews = data().deepCopy(fields()[3].schema(), other.count_reviews);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.count_five_stars)) {
        this.count_five_stars = data().deepCopy(fields()[4].schema(), other.count_five_stars);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.count_four_stars)) {
        this.count_four_stars = data().deepCopy(fields()[5].schema(), other.count_four_stars);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.count_three_stars)) {
        this.count_three_stars = data().deepCopy(fields()[6].schema(), other.count_three_stars);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.count_two_stars)) {
        this.count_two_stars = data().deepCopy(fields()[7].schema(), other.count_two_stars);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.count_one_star)) {
        this.count_one_star = data().deepCopy(fields()[8].schema(), other.count_one_star);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.count_zero_star)) {
        this.count_zero_star = data().deepCopy(fields()[9].schema(), other.count_zero_star);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.last_review_time)) {
        this.last_review_time = data().deepCopy(fields()[10].schema(), other.last_review_time);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.sum_rating)) {
        this.sum_rating = data().deepCopy(fields()[11].schema(), other.sum_rating);
        fieldSetFlags()[11] = true;
      }
    }

    /**
      * Gets the value of the 'course_id' field.
      * Course ID in Udemy's DB
      * @return The value.
      */
    public java.lang.Long getCourseId() {
      return course_id;
    }

    /**
      * Sets the value of the 'course_id' field.
      * Course ID in Udemy's DB
      * @param value The value of 'course_id'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCourseId(long value) {
      validate(fields()[0], value);
      this.course_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'course_id' field has been set.
      * Course ID in Udemy's DB
      * @return True if the 'course_id' field has been set, false otherwise.
      */
    public boolean hasCourseId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'course_id' field.
      * Course ID in Udemy's DB
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCourseId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'course_title' field.
      * Course Title
      * @return The value.
      */
    public java.lang.CharSequence getCourseTitle() {
      return course_title;
    }

    /**
      * Sets the value of the 'course_title' field.
      * Course Title
      * @param value The value of 'course_title'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCourseTitle(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.course_title = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'course_title' field has been set.
      * Course Title
      * @return True if the 'course_title' field has been set, false otherwise.
      */
    public boolean hasCourseTitle() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'course_title' field.
      * Course Title
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCourseTitle() {
      course_title = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'average_rating' field.
      * @return The value.
      */
    public java.lang.Double getAverageRating() {
      return average_rating;
    }

    /**
      * Sets the value of the 'average_rating' field.
      * @param value The value of 'average_rating'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setAverageRating(double value) {
      validate(fields()[2], value);
      this.average_rating = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'average_rating' field has been set.
      * @return True if the 'average_rating' field has been set, false otherwise.
      */
    public boolean hasAverageRating() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'average_rating' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearAverageRating() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_reviews' field.
      * @return The value.
      */
    public java.lang.Long getCountReviews() {
      return count_reviews;
    }

    /**
      * Sets the value of the 'count_reviews' field.
      * @param value The value of 'count_reviews'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountReviews(long value) {
      validate(fields()[3], value);
      this.count_reviews = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'count_reviews' field has been set.
      * @return True if the 'count_reviews' field has been set, false otherwise.
      */
    public boolean hasCountReviews() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'count_reviews' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountReviews() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_five_stars' field.
      * @return The value.
      */
    public java.lang.Long getCountFiveStars() {
      return count_five_stars;
    }

    /**
      * Sets the value of the 'count_five_stars' field.
      * @param value The value of 'count_five_stars'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountFiveStars(long value) {
      validate(fields()[4], value);
      this.count_five_stars = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'count_five_stars' field has been set.
      * @return True if the 'count_five_stars' field has been set, false otherwise.
      */
    public boolean hasCountFiveStars() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'count_five_stars' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountFiveStars() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_four_stars' field.
      * @return The value.
      */
    public java.lang.Long getCountFourStars() {
      return count_four_stars;
    }

    /**
      * Sets the value of the 'count_four_stars' field.
      * @param value The value of 'count_four_stars'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountFourStars(long value) {
      validate(fields()[5], value);
      this.count_four_stars = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'count_four_stars' field has been set.
      * @return True if the 'count_four_stars' field has been set, false otherwise.
      */
    public boolean hasCountFourStars() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'count_four_stars' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountFourStars() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_three_stars' field.
      * @return The value.
      */
    public java.lang.Long getCountThreeStars() {
      return count_three_stars;
    }

    /**
      * Sets the value of the 'count_three_stars' field.
      * @param value The value of 'count_three_stars'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountThreeStars(long value) {
      validate(fields()[6], value);
      this.count_three_stars = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'count_three_stars' field has been set.
      * @return True if the 'count_three_stars' field has been set, false otherwise.
      */
    public boolean hasCountThreeStars() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'count_three_stars' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountThreeStars() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_two_stars' field.
      * @return The value.
      */
    public java.lang.Long getCountTwoStars() {
      return count_two_stars;
    }

    /**
      * Sets the value of the 'count_two_stars' field.
      * @param value The value of 'count_two_stars'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountTwoStars(long value) {
      validate(fields()[7], value);
      this.count_two_stars = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'count_two_stars' field has been set.
      * @return True if the 'count_two_stars' field has been set, false otherwise.
      */
    public boolean hasCountTwoStars() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'count_two_stars' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountTwoStars() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_one_star' field.
      * @return The value.
      */
    public java.lang.Long getCountOneStar() {
      return count_one_star;
    }

    /**
      * Sets the value of the 'count_one_star' field.
      * @param value The value of 'count_one_star'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountOneStar(long value) {
      validate(fields()[8], value);
      this.count_one_star = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'count_one_star' field has been set.
      * @return True if the 'count_one_star' field has been set, false otherwise.
      */
    public boolean hasCountOneStar() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'count_one_star' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountOneStar() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'count_zero_star' field.
      * @return The value.
      */
    public java.lang.Long getCountZeroStar() {
      return count_zero_star;
    }

    /**
      * Sets the value of the 'count_zero_star' field.
      * @param value The value of 'count_zero_star'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setCountZeroStar(long value) {
      validate(fields()[9], value);
      this.count_zero_star = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'count_zero_star' field has been set.
      * @return True if the 'count_zero_star' field has been set, false otherwise.
      */
    public boolean hasCountZeroStar() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'count_zero_star' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearCountZeroStar() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'last_review_time' field.
      * last review in aggregation
      * @return The value.
      */
    public org.joda.time.DateTime getLastReviewTime() {
      return last_review_time;
    }

    /**
      * Sets the value of the 'last_review_time' field.
      * last review in aggregation
      * @param value The value of 'last_review_time'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setLastReviewTime(org.joda.time.DateTime value) {
      validate(fields()[10], value);
      this.last_review_time = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'last_review_time' field has been set.
      * last review in aggregation
      * @return True if the 'last_review_time' field has been set, false otherwise.
      */
    public boolean hasLastReviewTime() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'last_review_time' field.
      * last review in aggregation
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearLastReviewTime() {
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'sum_rating' field.
      * @return The value.
      */
    public java.lang.Double getSumRating() {
      return sum_rating;
    }

    /**
      * Sets the value of the 'sum_rating' field.
      * @param value The value of 'sum_rating'.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder setSumRating(double value) {
      validate(fields()[11], value);
      this.sum_rating = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'sum_rating' field has been set.
      * @return True if the 'sum_rating' field has been set, false otherwise.
      */
    public boolean hasSumRating() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'sum_rating' field.
      * @return This builder.
      */
    public com.github.amitsoni.avro.udemy.CourseStatistic.Builder clearSumRating() {
      fieldSetFlags()[11] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CourseStatistic build() {
      try {
        CourseStatistic record = new CourseStatistic();
        record.course_id = fieldSetFlags()[0] ? this.course_id : (java.lang.Long) defaultValue(fields()[0], record.getConversion(0));
        record.course_title = fieldSetFlags()[1] ? this.course_title : (java.lang.CharSequence) defaultValue(fields()[1], record.getConversion(1));
        record.average_rating = fieldSetFlags()[2] ? this.average_rating : (java.lang.Double) defaultValue(fields()[2], record.getConversion(2));
        record.count_reviews = fieldSetFlags()[3] ? this.count_reviews : (java.lang.Long) defaultValue(fields()[3], record.getConversion(3));
        record.count_five_stars = fieldSetFlags()[4] ? this.count_five_stars : (java.lang.Long) defaultValue(fields()[4], record.getConversion(4));
        record.count_four_stars = fieldSetFlags()[5] ? this.count_four_stars : (java.lang.Long) defaultValue(fields()[5], record.getConversion(5));
        record.count_three_stars = fieldSetFlags()[6] ? this.count_three_stars : (java.lang.Long) defaultValue(fields()[6], record.getConversion(6));
        record.count_two_stars = fieldSetFlags()[7] ? this.count_two_stars : (java.lang.Long) defaultValue(fields()[7], record.getConversion(7));
        record.count_one_star = fieldSetFlags()[8] ? this.count_one_star : (java.lang.Long) defaultValue(fields()[8], record.getConversion(8));
        record.count_zero_star = fieldSetFlags()[9] ? this.count_zero_star : (java.lang.Long) defaultValue(fields()[9], record.getConversion(9));
        record.last_review_time = fieldSetFlags()[10] ? this.last_review_time : (org.joda.time.DateTime) defaultValue(fields()[10], record.getConversion(10));
        record.sum_rating = fieldSetFlags()[11] ? this.sum_rating : (java.lang.Double) defaultValue(fields()[11], record.getConversion(11));
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CourseStatistic>
    WRITER$ = (org.apache.avro.io.DatumWriter<CourseStatistic>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CourseStatistic>
    READER$ = (org.apache.avro.io.DatumReader<CourseStatistic>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}