package markoff.os.musicplayer.presenters.player;

import android.content.Intent;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.presenters.BasePresenter;
import markoff.os.musicplayer.views.explorer.ActivityFileExplorer;
import markoff.os.musicplayer.views.player.ActivityPlayer;

/**
 * Created by Markov O on 11.10.16.
 */

public final class PlayerPresenter extends BasePresenter<ActivityPlayer> {

    @Override
    public void onClick(int viewId) {

        switch (viewId) {
            case R.id.btn_add: {
                Intent intent = new Intent(view.getContext(), ActivityFileExplorer.class);
                view.getContext().startActivity(intent);
                break;
            }
        }

    }
}
