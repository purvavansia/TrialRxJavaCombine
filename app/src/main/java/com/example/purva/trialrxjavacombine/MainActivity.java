package com.example.purva.trialrxjavacombine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    final static String BASE_URL = "http://rjtmobile.com/aamir/property-mgmt/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();

        final Observable<Property> propertyObservable = retrofit.create(ApiService.class).getPropertyDetails("31", "landlord");


        retrofit.create(ApiService.class)
                .addPropertyDetails("abc", "abc", "abc", "abc", "tenants", "1200", "no", "31", "landlord")

                .flatMap(new Function<String, ObservableSource<Property>>() {
                    @Override
                    public ObservableSource<Property> apply(String reponse) throws Exception {

                        Log.i("response",""+reponse);
                        if (reponse.contains("successfully")) {

                            Log.i("response",""+reponse);
                            return propertyObservable;
                        }
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Property>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("response","subscribed");

                    }

                    @Override
                    public void onNext(Property property) {
                        Log.i("response",property.getProperty().get(0).getId());
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("response","error"+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("response","completed");
                    }
                });


    }
}
