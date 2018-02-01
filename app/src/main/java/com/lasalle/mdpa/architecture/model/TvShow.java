package com.lasalle.mdpa.architecture.model;

/**
 * Created by albert on 27/01/2018.
 */

public class TvShow {

    private String title;
    private boolean ended;
    private int seasons;

    public TvShow(String title, boolean ended, int seasons) {
        this.title = title;
        this.ended = ended;
        this.seasons = seasons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

}
