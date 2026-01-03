package com.aghakhani.fullfundapp.data.model;

/**
 * Represents a single funding/position item displayed in the main feed.
 * This model is intentionally minimal for Phase 1 (list only).
 */
public class Post {

    private final int id;
    private final String title;
    private final String university;
    private final String country;       // e.g., "Canada"
    private final String countryCode;   // e.g., "CA" used for mapping the flag icon
    private final String level;         // e.g., "PhD"
    private final String fundType;      // e.g., "Fully Funded"
    private final String deadline;      // e.g., "2026-02-10"
    private final String link;          // The URL to open when the item is clicked

    public Post(int id,
                String title,
                String university,
                String country,
                String countryCode,
                String level,
                String fundType,
                String deadline,
                String link) {
        this.id = id;
        this.title = title;
        this.university = university;
        this.country = country;
        this.countryCode = countryCode;
        this.level = level;
        this.fundType = fundType;
        this.deadline = deadline;
        this.link = link;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getUniversity() { return university; }
    public String getCountry() { return country; }
    public String getCountryCode() { return countryCode; }
    public String getLevel() { return level; }
    public String getFundType() { return fundType; }
    public String getDeadline() { return deadline; }
    public String getLink() { return link; }

    /**
     * @return true if the link field is non-empty and can be opened.
     */
    public boolean hasLink() {
        return link != null && !link.trim().isEmpty();
    }
}
