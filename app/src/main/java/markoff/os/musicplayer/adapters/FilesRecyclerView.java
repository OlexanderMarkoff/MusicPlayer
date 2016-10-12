package markoff.os.musicplayer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import markoff.os.musicplayer.R;

/**
 * Created by Markov O on 12.10.16.
 */

public class FilesRecyclerView extends RecyclerView.Adapter<FilesRecyclerView.FilesViewHolder> {

    private List<File> data;

    public FilesRecyclerView(List<File> data) {
        this.data = data;
    }

    @Override
    public FilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_explorer, parent, false);

        FilesViewHolder vh = new FilesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FilesViewHolder holder, int position) {
        holder.filename.setText(data.get(position).getName());
        holder.fileSelector.setEnabled(!data.get(position).isDirectory());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class FilesViewHolder extends RecyclerView.ViewHolder {

        private ImageView fileIcon;
        private TextView filename;
        private TextView fileInfo;
        private CheckBox fileSelector;

        public FilesViewHolder(View v) {
            super(v);
            fileIcon = (ImageView) v.findViewById(R.id.img_file);
            filename = (TextView) v.findViewById(R.id.txt_filename);
            fileInfo = (TextView) v.findViewById(R.id.txt_fileinfo);
            fileSelector = (CheckBox) v.findViewById(R.id.chb_selector);
        }
    }
}
