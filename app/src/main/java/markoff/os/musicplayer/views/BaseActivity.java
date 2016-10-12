package markoff.os.musicplayer.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.presenters.BasePresenter;
import markoff.os.musicplayer.presenters.Presenter;

/**
 * Created by Markov O on 11.10.16.
 */

public abstract class BaseActivity<T extends Presenter> extends Activity implements View.OnClickListener, MusicPlayerView {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setUI();
        setListeners();
        presenter = getNeededPresenter();
        subscribeToPresenter();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BasePresenter.PresenterManager.removePresenter(presenter);
        unSubscribeFromPresenter();
    }

    protected abstract void initUI();

    protected abstract void setUI();

    protected abstract void setListeners();

    protected abstract T getNeededPresenter();

    protected void subscribeToPresenter() {
       presenter.subscribe(this);
    }

    protected void unSubscribeFromPresenter() {
        if (presenter != null && presenter.unSubscribe(this)) {
            presenter = null;
        }
    }

    @Override
    public void onClick(View v) {
        presenter.onClick(v.getId());
    }

    protected void playShakeAnimation(android.view.View view) {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake_buton_anim);
        view.startAnimation(shake);
    }

    public Context getContext() {
        return this;
    }

}
