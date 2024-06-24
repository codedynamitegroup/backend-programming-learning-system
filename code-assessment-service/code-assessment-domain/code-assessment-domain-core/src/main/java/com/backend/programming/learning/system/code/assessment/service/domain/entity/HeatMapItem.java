package com.backend.programming.learning.system.code.assessment.service.domain.entity;

import java.util.Date;

public class HeatMapItem {
    Date date;
    Integer numOfSubmission;

    private HeatMapItem(Builder builder) {
        date = builder.date;
        numOfSubmission = builder.numOfSubmission;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Date getDate() {
        return date;
    }

    public Integer getNumOfSubmission() {
        return numOfSubmission;
    }

    public static final class Builder {
        private Date date;
        private Integer numOfSubmission;

        private Builder() {
        }

        public Builder date(Date val) {
            date = val;
            return this;
        }

        public Builder numOfSubmission(Integer val) {
            numOfSubmission = val;
            return this;
        }

        public HeatMapItem build() {
            return new HeatMapItem(this);
        }
    }
}
