package markoff.os.musicplayer.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import markoff.os.musicplayer.views.MusicPlayerView;

/**
 * Created by Markov O on 12.10.16.
 */

public abstract class BasePresenter<T extends MusicPlayerView> implements Presenter<T> {

    protected T view;

    protected BasePresenter() {
    }

    @Override
    public void subscribe(T view) {
        this.view = view;
    }

    @Override
    public boolean isSubscribed(T view) {
        return view.equals(this.view);
    }

    @Override
    public boolean unSubscribe(MusicPlayerView v) {
        if (v.equals(view)) {
            view = null;
        }
        return view == null;
    }

    public static class PresenterManager {

        private static final List<Presenter> PRESENTERS = new ArrayList<Presenter>();

        private PresenterManager() {
        }

        public static Presenter getPresenter(Class<? extends BasePresenter> clazz) {

            if (!isContainsPresenterInstance(clazz)) {
                try {
                    Presenter p = clazz.newInstance();
                    PRESENTERS.add(p);
                    return p;
                } catch (Throwable e) {
                    Log.e(PresenterManager.class.getCanonicalName(), "Cannot create an instance of the class " + clazz.getSimpleName(), e);
                }
            }

            return getFromList(clazz);
        }

        public static void removePresenter(Presenter presenter) {
            PRESENTERS.remove(presenter);
        }

        private static boolean isContainsPresenterInstance(Class<? extends BasePresenter> clazz) {
            if (PRESENTERS.size() == 0) {
                return false;
            }

            return getFromList(clazz) != null;
        }

        private static Presenter getFromList(Class<? extends BasePresenter> clazz) {
            for (Presenter p : PRESENTERS) {
                if (clazz.isInstance(p)) {
                    System.out.println(1);
                    return p;
                }
            }
            return null;
        }
    }

}



