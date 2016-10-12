package markoff.os.musicplayer.presenters;


import markoff.os.musicplayer.views.MusicPlayerView;

/**
 * Created by Markov O on 11.10.16.
 */

public interface Presenter<T extends MusicPlayerView> {

    void subscribe(T v);
    boolean unSubscribe(T v);
    void onClick(int viewId);
    boolean isSubscribed(T view);
}
