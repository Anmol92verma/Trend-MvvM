package com.example.anmol;

import android.app.Application;
import android.content.Context;

import com.example.anmol.model.GithubService;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ArchiApplication extends Application {

    private GithubService githubService;
    private Scheduler defaultSubscribeScheduler;

    public static ArchiApplication get(Context context) {
        return (ArchiApplication) context.getApplicationContext();
    }

    public GithubService getGithubService() {
        if (githubService == null) {
            githubService = GithubService.Factory.create();
        }
        return githubService;
    }

    //For setting mocks during testing
    public void setGithubService(GithubService githubService) {
        this.githubService = githubService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}