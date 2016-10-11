package markoff.os.musicplayer.presenters;


import markoff.os.musicplayer.views.View;

/**
 * Created by Markov O on 11.10.16.
 */

public interface Presenter {

    void subscribe(View v);
    boolean unSubscribe(View v);
    void onClick(int viewId);
}
