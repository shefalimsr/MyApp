package com.example.pay1.community.database;

import android.content.Context;
import android.util.Log;

import com.example.pay1.community.TRAINING.Training;
import com.example.pay1.community.database.entity.TrainingEntity;
import com.example.pay1.community.database.entity.HomEntity;
import com.example.pay1.community.database.entity.UpdateEntity;
import com.example.pay1.community.HOME.Home;
import com.example.pay1.community.UPDATE.Update;

import java.util.List;


import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DatabaseManager {
    private Context context;

    public static DatabaseManager getInstance(Context context) {
        return new DatabaseManager(context);
    }

    private DatabaseManager(Context context)
    {
        this.context = context;
    }


 // ------------------------------------------------------ Get all feed entries -----------------------------------------------------------

    public Observable<TrainingEntity> getAllFeedEntries() {
        return Observable.create(new ObservableOnSubscribe<TrainingEntity>() {
            @Override
            public void subscribe(ObservableEmitter<TrainingEntity> emitter) throws Exception {
                List<TrainingEntity> trainingEntity = ApplicationDatabase.getInstance(context).feedDao().getAll(2);
                for(TrainingEntity en : trainingEntity) {
                    if(!emitter.isDisposed()) emitter.onNext(en);
                }
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }



    // ------------------------------------------------------ Get all home entries -----------------------------------------------------------

    public Observable<HomEntity> getAllHomeEntries()
    {
        return Observable.create(new ObservableOnSubscribe<HomEntity>()
        {
            @Override
            public void subscribe(ObservableEmitter<HomEntity> emitter) throws Exception
            {
                List<HomEntity> homEntities = ApplicationDatabase.getInstance(context).homeDao().getAll();
                for(HomEntity en : homEntities)
                {
                    Log.d("__",en.getType()+"");
                    if(!emitter.isDisposed()) emitter.onNext(en);
                }
                if(!emitter.isDisposed())
                {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }



    // ------------------------------------------------------ Get all update entries -----------------------------------------------------------

    public Observable<UpdateEntity> getAllUpdateEntries()
    {
        return Observable.create(new ObservableOnSubscribe<UpdateEntity>()
        {
            @Override
            public void subscribe(ObservableEmitter<UpdateEntity> emitter) throws Exception
            {
                List<UpdateEntity> updateEntities = ApplicationDatabase.getInstance(context).updateDao().getAll(1);
                for(UpdateEntity en : updateEntities)
                {
                    if(!emitter.isDisposed()) emitter.onNext(en);
                }
                if(!emitter.isDisposed())
                {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    // ------------------------------------------------------ insert single feed entries -----------------------------------------------------------

    public Completable insertfeed(final Training feedi) {
        return  Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {


                TrainingEntity trainingEntity = new TrainingEntity();
                trainingEntity.setTitle(feedi.getTitle());
                trainingEntity.setIconUrl(feedi.getIconUrl());
                trainingEntity.setTimestamp(feedi.getTimestamp());
                trainingEntity.setTitleUrl(feedi.getTitleUrl());
                trainingEntity.setType(feedi.getType());


                ApplicationDatabase.getInstance(context).feedDao().insertSingle(trainingEntity);
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    // ------------------------------------------------------ insert single home entries -----------------------------------------------------------

    public Completable inserthome(final Home homi) {
        return  Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {


                HomEntity homEntity = new HomEntity();
                homEntity.setTitle(homi.getTitle());
                homEntity.setIconUrl(homi.getIconUrl());
                homEntity.setTimestamp(homi.getTimestamp());
                homEntity.setTitleUrl(homi.getTitleUrl());
                homEntity.setType(homi.getType());


                ApplicationDatabase.getInstance(context).homeDao().insertSingle(homEntity);
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }



    // ------------------------------------------------------ insert single update entries -----------------------------------------------------------

    public Completable insertupdate(final Update update) {
        return  Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {


                UpdateEntity updateEntity = new UpdateEntity();
                updateEntity.setTitle(update.getTitle());
                updateEntity.setIconUrl(update.getIconUrl());
                updateEntity.setTimestamp(update.getTimestamp());
                updateEntity.setTitleUrl(update.getTitleUrl());
                updateEntity.setType(update.getType());


                ApplicationDatabase.getInstance(context).updateDao().insertSingle(updateEntity);
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    // ------------------------------------------------------ delete all feed entries -----------------------------------------------------------
    public Completable deleteAllFeedEntries() {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                ApplicationDatabase.getInstance(context).feedDao().deleteAll();
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    // ------------------------------------------------------ delete all home entries -----------------------------------------------------------
    public Completable deleteAllHomeEntries() {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                ApplicationDatabase.getInstance(context).homeDao().deleteAll();
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    // ------------------------------------------------------ delete all update entries -----------------------------------------------------------
    public Completable deleteAllUpdateEntries() {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                ApplicationDatabase.getInstance(context).updateDao().deleteAll();
                if(!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


}
