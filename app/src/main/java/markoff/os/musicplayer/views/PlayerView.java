package markoff.os.musicplayer.views;

/**
 * Created by Markov O on 11.10.16.
 */

public interface PlayerView extends View {

    void setAudioLength(int length);

    void setProgress(int progress);
}
