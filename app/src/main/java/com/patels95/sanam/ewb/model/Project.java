package com.patels95.sanam.ewb.model;


import java.io.File;

public class Project {

    private String mTitle;
    private String mDescription;
    private String mImageUri;
    private Task[] mTasks;
    private String parseId;
    private File[] mResources;

    public Project() {
        // default constructor
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImageUri() {
        return mImageUri;
    }

    public void setImageUri(String imageUri) {
        mImageUri = imageUri;
    }

    public Task[] getTasks() {
        return mTasks;
    }

    public void setTasks(Task[] tasks) {
        mTasks = tasks;
    }

    public String getParseId() {
        return parseId;
    }

    public void setParseId(String parseId) {
        this.parseId = parseId;
    }

    public File[] getResources() {
        return mResources;
    }

    public void setResources(File[] resources) {
        mResources = resources;
    }
}
