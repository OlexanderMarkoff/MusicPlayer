package markoff.os.musicplayer.views;

import android.content.Context;

import java.util.List;

/**
 * Created by Markov O on 11.10.16.
 */

public interface MusicPlayerView {

    void setListData(List<?> data);

    void updateListData(List<?> data);

    Context getContext();
}
