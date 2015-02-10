package com.thomsonreuters.demo.benchmark;

public class Response {

    private final long id;
    private final long responseTimeInMillis;

    public Response(long id, long responseTimeInMillis) {
        this.id = id;
        this.responseTimeInMillis = responseTimeInMillis;
    }

    public long getId() {
        return id;
    }

    public long getResponseTimeInMillis() {
        return responseTimeInMillis;
    }
}
