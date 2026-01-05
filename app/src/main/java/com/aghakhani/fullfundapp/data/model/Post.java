package com.aghakhani.fullfundapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a single funding/position item coming from the backend API.
 * This POJO is Gson-friendly (no-args constructor + non-final fields).
 */
public class Post {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("university")
    private String university;

    @SerializedName("country")
    private String country;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName("level")
    private String level;

    @SerializedName("fundType")
    private String fundType;

    @SerializedName("deadline")
    private String deadline;

    @SerializedName("link")
    private String link;

    @SerializedName("createdAt")
    private long createdAt;

    /** Required empty constructor for Gson. */
    public Post() {}

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getUniversity() { return university; }
    public String getCountry() { return country; }
    public String getCountryCode() { return countryCode; }
    public String getLevel() { return level; }
    public String getFundType() { return fundType; }
    public String getDeadline() { return deadline; }
    public String getLink() { return link; }
    public long getCreatedAt() { return createdAt; }

    /**
     * @return true if the link field is non-empty and can be opened.
     */
    public boolean hasLink() {
        return link != null && !link.trim().isEmpty();
    }
}
