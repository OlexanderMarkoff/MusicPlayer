package markoff.os.musicplayer.views.player;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.presenters.player.PlayerPresenter;
import markoff.os.musicplayer.views.BaseActivity;
import markoff.os.musicplayer.views.PlayerView;

/**
 * Created by Markov O on 10.10.16.
 */

public class ActivityPlayer extends BaseActivity<PlayerPresenter> implements PlayerView {

    private ImageView btnShuffle;
    private ImageView btnAdd;
    private ImageView btnRepeat;
    private ImageView btnPrev;
    private ImageView btnPlayPause;
    private ImageView btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_player);
        super.onCreate(savedInstanceState);
    }

    protected void initUI() {
        btnShuffle = (ImageView) findViewById(R.id.btn_shuffle);
        btnAdd = (ImageView) findViewById(R.id.btn_add);
        btnRepeat = (ImageView) findViewById(R.id.btn_repeat);
        btnPrev = (ImageView) findViewById(R.id.btn_prev);
        btnPlayPause = (ImageView) findViewById(R.id.btn_play_pause);
        btnNext = (ImageView) findViewById(R.id.btn_next);

    }

    @Override
    protected void setUI() {

    }

    protected void setListeners() {
        btnShuffle.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRepeat.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        btnPlayPause.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        playShakeAnimation(v);
        super.onClick(v);
    }

    @Override
    public void setAudioLength(int length) {

    }

    @Override
    public void setListData(List<?> data) {

    }

    @Override
    public void updateListData(List<?> data) {

    }

    @Override
    protected void subscribeToPresenter() {
        presenter = PlayerPresenter.getInstance();
        presenter.subscribe(this);
    }

    @Override
    protected void unSubscribeFromPresenter() {
        presenter.unSubscribe(this);
    }

}
