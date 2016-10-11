package markoff.os.musicplayer.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.presenters.Presenter;

/**
 * Created by Markov O on 11.10.16.
 */

public abstract class BaseActivity<T extends Presenter> extends Activity implements android.view.View.OnClickListener {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setUI();
        setListeners();
        subscribeToPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribeFromPresenter();
    }

    protected abstract void initUI();

    protected abstract void setUI();

    protected abstract void setListeners();


    protected abstract void subscribeToPresenter();

    protected abstract void unSubscribeFromPresenter();

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
