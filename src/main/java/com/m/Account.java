package com.m;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnLoad;
import com.googlecode.objectify.annotation.OnSave;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
public class Account {

    @Id
    private String userId;

    private int credits;

    private String bucket;

    private Account() {
    }

    public Account(String userId, int credits, String bucket) {
        this.userId = userId;
        this.credits = credits;
        this.bucket = bucket;

        validate();
    }

    @OnLoad
    private void validate(){
        System.out.println("validate");

        Preconditions.checkArgument(!Strings.isNullOrEmpty(userId));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(bucket));
        Preconditions.checkArgument(credits >= 0);
    }

    @OnLoad
    private void validate2(){
        System.out.println("validate");

        Preconditions.checkArgument(!Strings.isNullOrEmpty(userId));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(bucket));
        Preconditions.checkArgument(credits >= 0);
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public int getCredits() {
        return credits;
    }

    @OnSave
    public void gg(){
        bucket = new Date().toString();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("userId", userId).append("credits", credits).append("bucket", bucket).toString();
    }
}
