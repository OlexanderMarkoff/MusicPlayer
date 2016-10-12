package markoff.os.musicplayer.views.explorer;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.File;
import java.util.List;

import markoff.os.musicplayer.R;
import markoff.os.musicplayer.adapters.FilesRecyclerView;
import markoff.os.musicplayer.presenters.BasePresenter;
import markoff.os.musicplayer.presenters.explorer.FileExplorerPresenter;
import markoff.os.musicplayer.views.BaseActivity;

/**
 * Created by Markov O on 11.10.16.
 */

public class ActivityFileExplorer extends BaseActivity<FileExplorerPresenter> {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_explorer);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initUI() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_files);
    }

    @Override
    protected void setUI() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected FileExplorerPresenter getNeededPresenter() {
        return (FileExplorerPresenter) BasePresenter.PresenterManager.getPresenter(FileExplorerPresenter.class);
    }

    @Override
    public void setListData(List<?> data) {

        FilesRecyclerView adapter = new FilesRecyclerView((List<File>) data);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateListData(List<?> data) {

    }
}
