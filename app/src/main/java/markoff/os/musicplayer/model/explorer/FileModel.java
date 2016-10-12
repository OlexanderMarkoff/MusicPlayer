package markoff.os.musicplayer.model.explorer;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import markoff.os.musicplayer.presenters.LoadDataListener;

/**
 * Created by Markov O on 12.10.16.
 */

public class FileModel {

    private File currentDir;
    private Stack<File> history;
    public static final String TAG = "Current dir";

    private LoadDataListener loadDataListener;

    public FileModel(LoadDataListener loadDataListener) {
        this.loadDataListener = loadDataListener;
        init();
    }

    private void init() {
        history = new Stack<>();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            currentDir = Environment.getExternalStorageDirectory();
            loadDataListener.dataLoaded(currentDir.listFiles());
            Log.i(TAG, String.valueOf(currentDir));
        } else {
            Log.i(TAG, "External storage unavailable");
        }
    }

    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File currentDir) {
        this.currentDir = currentDir;
    }

    public boolean hasPreviousDir() {
        return !history.isEmpty();
    }

    public File getPreviousDir() {
        return history.pop();
    }

    public List<File> getAllFiles(File f) {
        File[] allFiles = f.listFiles();


        List<File> dirs = new ArrayList<>();
        List<File> files = new ArrayList<>();

        for (File file : allFiles) {
            if (file.isDirectory()) {
                dirs.add(file);
            } else {
                files.add(file);
            }
        }

        Collections.sort(dirs);
        Collections.sort(files);

        dirs.addAll(files);

        return dirs;
    }

    public String getMimeType(Uri uri) {
        String mimeType = null;

        String extension = MimeTypeMap.getFileExtensionFromUrl(uri.getPath());

        if (MimeTypeMap.getSingleton().hasExtension(extension)) {

            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return mimeType;
    }
}
