package com.example.asus.project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by thefilm on 21/5/2561.
 */

public class HomeDao {
    @SerializedName("done")
    private float done;

    @SerializedName("delay")
    private float delay;

    @SerializedName("count_num")
    private List<String> count_num;

    @SerializedName("percents")
    private List<String> percent;

    public float getDone() {
        return done;
    }

    public void setDone(float done) {
        this.done = done;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public List<String> getCount_num() {
        return count_num;
    }

    public void setCount_num(List<String> count_num) {
        this.count_num = count_num;
    }

    public List<String> getPercent() {
        return percent;
    }

    public void setPercent(List<String> percent) {
        this.percent = percent;
    }
}
