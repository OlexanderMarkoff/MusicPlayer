package markoff.os.musicplayer.presenters.explorer;

import java.io.File;
import java.util.Arrays;

import markoff.os.musicplayer.model.explorer.FileModel;
import markoff.os.musicplayer.presenters.BasePresenter;
import markoff.os.musicplayer.presenters.LoadDataListener;
import markoff.os.musicplayer.views.MusicPlayerView;

/**
 * Created by Markov O on 11.10.16.
 */

public class FileExplorerPresenter extends BasePresenter<MusicPlayerView> implements LoadDataListener<File[]> {

    private FileModel model;

    @Override
    public void onClick(int viewId) {
    }

    @Override
    public void dataLoaded(File[] data) {
        view.setListData(Arrays.asList(data));
    }

    @Override
    public void subscribe(MusicPlayerView view) {
        super.subscribe(view);
        model = new FileModel(this);
    }
}
