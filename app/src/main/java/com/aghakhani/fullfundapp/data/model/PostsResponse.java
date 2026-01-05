package com.aghakhani.fullfundapp.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Represents the server response for the posts list endpoint.
 * Matches the JSON structure: { data: [...], page: 1, limit: 30, total: 3 }
 */
public class PostsResponse {

    @SerializedName("data")
    private List<Post> data;

    @SerializedName("page")
    private int page;

    @SerializedName("limit")
    private int limit;

    @SerializedName("total")
    private int total;

    public List<Post> getData() { return data; }
    public int getPage() { return page; }
    public int getLimit() { return limit; }
    public int getTotal() { return total; }
}
