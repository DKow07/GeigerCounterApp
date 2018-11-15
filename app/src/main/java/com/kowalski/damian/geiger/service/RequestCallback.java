package com.kowalski.damian.geiger.service;

/**
 * Created by Damian on 21.07.2018.
 */

public interface RequestCallback<T> {

    void onSuccess(T data);

    void onError(Throwable throwable);

    void onCancel();
}
