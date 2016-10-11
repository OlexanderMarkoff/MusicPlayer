package markoff.os.musicplayer.views.explorer;


import android.os.Bundle;

import java.util.List;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.presenters.explorer.FileExplorerPresenter;
import markoff.os.musicplayer.views.BaseActivity;
import markoff.os.musicplayer.views.View;

/**
 * Created by Markov O on 11.10.16.
 */

public class ActivityFileExplorer extends BaseActivity<FileExplorerPresenter> implements View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_explorer);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void setUI() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    public void onClick(android.view.View v) {

    }

    @Override
    protected void subscribeToPresenter() {

    }

    @Override
    protected void unSubscribeFromPresenter() {

    }

    @Override
    public void setListData(List<?> data) {

    }

    @Override
    public void updateListData(List<?> data) {

    }
}
