package markoff.os.musicplayer.presenters.player;

import android.content.Intent;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.presenters.Presenter;
import markoff.os.musicplayer.views.View;
import markoff.os.musicplayer.views.explorer.ActivityFileExplorer;

/**
 * Created by Markov O on 11.10.16.
 */

public final class PlayerPresenter implements Presenter {

    private static PlayerPresenter instance = null;
    private View view;

    private PlayerPresenter() {
    }

    public static PlayerPresenter getInstance() {
        if (instance == null) {
            instance = new PlayerPresenter();
        }

        return instance;
    }

    @Override
    public void subscribe(View v) {
        view = v;
    }

    @Override
    public boolean unSubscribe(View v) {
        if (v.equals(view)) {
            view = null;
        }
        return view == null;
    }

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
