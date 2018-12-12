package www.winroad.data.callback;


import www.winroad.data.TaskObserver;

public abstract class LoadTaskCallback<T> implements TaskObserver<T> {

    public void onStart(){ }

    public void onCompleted(){ }
}
