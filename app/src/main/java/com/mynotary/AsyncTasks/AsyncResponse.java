package com.mynotary.AsyncTasks;

import org.json.JSONArray;

/**
 * Created by Dell on 11-01-2017.
 */

public interface AsyncResponse {
    void onSuccess(String message, JSONArray jsonData);
    void onFailure(String message);
}
