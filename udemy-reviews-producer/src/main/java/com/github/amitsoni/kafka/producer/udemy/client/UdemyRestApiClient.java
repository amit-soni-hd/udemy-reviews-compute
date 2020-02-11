package com.github.amitsoni.kafka.producer.udemy.client;

import com.github.amitsoni.avro.udemy.Course;
import com.github.amitsoni.avro.udemy.Review;
import com.github.amitsoni.avro.udemy.User;
import com.github.amitsoni.kafka.producer.udemy.config.AppConfig;
import com.github.amitsoni.kafka.producer.udemy.model.ReviewApiResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpException;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;


public class UdemyRestApiClient {

    private Logger logger = LoggerFactory.getLogger(UdemyRestApiClient.class.getSimpleName());

    private Integer count;
    private String courseId;
    private Integer nextPage;
    private AppConfig appConfig;
    final private Integer pageSize;

    public UdemyRestApiClient(AppConfig appConfig) {
        this.appConfig = appConfig;
        this.pageSize = appConfig.getUdemyPageSize();
        this.courseId = appConfig.getCourseId();
    }

    private List<Review> init() throws HttpException {
        logger.info("init() method call ");
        ReviewApiResponse reviewApiResponse = reviewApi(1, 1);
        count = reviewApiResponse.getCount();
        // fetch from next page
        this.nextPage = 50 ;
        return reviewApiResponse.getReviewList();

    }

    public List<Review> getNextReviews() throws HttpException {

        if(nextPage == null)
            return init();

        if(nextPage >= 1 ) {
            List<Review> reviewList = reviewApi(pageSize, nextPage).getReviewList();
            logger.info("Review list size : " + reviewList.size());
            nextPage -= 1;
            return reviewList;
        }
        return Collections.emptyList();
    }

    public ReviewApiResponse reviewApi(Integer pageSize, Integer page) throws HttpException {

        String url = "https://www.udemy.com/api-2.0/courses/" + courseId + "/reviews";
        String authorization = appConfig.getClient_id() + ":" + appConfig.getClient_secret();
        HttpResponse<JsonNode> httpResponse = null;
        try {
            httpResponse = Unirest.get(url)
//                    .header("Authorization", Base64.getEncoder().encodeToString(authorization.getBytes()))
                    .queryString("page", page)
                    .queryString("page_size", pageSize)
                    .queryString("fields[course_review]", "title,content,rating,created,modified,user_modified,user,course")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if(httpResponse.getStatus() == 200) {

            JSONObject body = httpResponse.getBody().getObject();
            Integer count = body.getInt("count");
            String next = body.optString("next");
            String previous = body.optString("previous");
            List<Review> reviewList = this.convertToReviewList(body.optJSONArray("results"));
            ReviewApiResponse reviewApiResponse = new ReviewApiResponse(count, next, previous, reviewList);

            return reviewApiResponse;
        }

        throw new HttpException("Udemy API unavailable ");
    }

    // convert json reviews to Array of review list
    private List<Review> convertToReviewList(JSONArray reviews) {
        List<Review> reviewList = new ArrayList<>();
        reviews.forEach(value -> {
                JSONObject jsonObject = (JSONObject)value;
                Review review = this.jsonToReview(jsonObject);
                reviewList.add(review);
        });
        return reviewList;
    }

    // convert to json object to Review object
    private Review jsonToReview(JSONObject jsonObject) {
        Review.Builder reviewBuilder = Review.newBuilder();
        reviewBuilder.setContent(jsonObject.getString("content"));
        reviewBuilder.setId(Long.valueOf(jsonObject.get("id").toString()));
        reviewBuilder.setRating(jsonObject.getBigDecimal("rating").toPlainString());
        reviewBuilder.setCreated(DateTime.parse(jsonObject.getString("created")));
        reviewBuilder.setModified(DateTime.parse(jsonObject.getString("modified")));
        reviewBuilder.setUser(jsonToUser(jsonObject.getJSONObject("user")));
        reviewBuilder.setCourse(jsonToCourse(jsonObject.getJSONObject("course")));
        return reviewBuilder.build();
    }

    // convert to json object to User object
    private User jsonToUser(JSONObject user) {
        User.Builder userBuilder = User.newBuilder();
        userBuilder.setName(user.getString("name"));
        userBuilder.setTitle(user.getString("title"));
        userBuilder.setDisplayName(user.getString("display_name"));
        return userBuilder.build();
    }

    // convert to json object to Course object
    private Course jsonToCourse(JSONObject course) {
        Course.Builder courseBuilder = Course.newBuilder();
        courseBuilder.setId(Long.valueOf(course.get("id").toString()));
        courseBuilder.setTitle(course.getString("title"));
        courseBuilder.setUrl(course.getString("url"));
        return courseBuilder.build();
    }

    // close the rest API
    public void close() {
        try {
            Unirest.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
