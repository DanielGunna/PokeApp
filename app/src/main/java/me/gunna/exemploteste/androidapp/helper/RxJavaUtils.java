package me.gunna.exemploteste.androidapp.helper;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by matheus on 16/01/17.
 */

public class RxJavaUtils {

    public static void checkUnsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    public static boolean isNullOrUnsubscribed(Subscription subscription) {
        return subscription == null || subscription.isUnsubscribed();
    }

    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
