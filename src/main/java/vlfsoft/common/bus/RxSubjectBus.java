package vlfsoft.common.bus;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;
import vlfsoft.common.annotations.design.patterns.etc.EtcShorthandPattern;

public class RxSubjectBus<BusinessObject> {

    private Subject<BusinessObject, BusinessObject> mBusinessObjectSubject;

    /**
     * @param aBusinessObjectSubject f.e. BehaviorSubject.create()
     */
    public RxSubjectBus(Subject<BusinessObject, BusinessObject> aBusinessObjectSubject) {
        mBusinessObjectSubject = aBusinessObjectSubject;
    }

    public RxSubjectBus() {
        mBusinessObjectSubject = BehaviorSubject.create();
    }

    public void onNext(BusinessObject aBusinessObject) {
        mBusinessObjectSubject.onNext(aBusinessObject);
    }

    @EtcShorthandPattern
    public void onNext() {
        // http://stackoverflow.com/questions/26145917/observable-which-does-not-pass-anything-in-onnext
        onNext(null);
    }

    public Observable<BusinessObject> getObservable() {
        return mBusinessObjectSubject;
    }

    @EtcShorthandPattern
    public Subscription subscribe() {
        return mBusinessObjectSubject.subscribe();
    }

    @EtcShorthandPattern
    public Subscription subscribe(Action1<? super BusinessObject> onNext) {
        return mBusinessObjectSubject.subscribe(onNext);
    }

    @EtcShorthandPattern
    public Subscription subscribe(Action1<? super BusinessObject> onNext,
                                  Action1<java.lang.Throwable> onError) {
        return mBusinessObjectSubject.subscribe(onNext, onError);
    }

    @EtcShorthandPattern
    public Subscription subscribe(Action1<? super BusinessObject> onNext,
                                  Action1<java.lang.Throwable> onError,
                                  Action0 onCompleted) {
        return mBusinessObjectSubject.subscribe(onNext, onError, onCompleted);
    }

}
