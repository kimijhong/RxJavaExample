package observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;

public class Example {

	public static void main(String[] args) {
		
		Observable<String>  observer  = Observable.just("1","2","3");
		
		observer.subscribe(new Observer() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println(d.isDisposed());
			}

			@Override
			public void onNext(Object t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println(e.getMessage());
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("¿Ï·á");
			}
		});
		
		observer.subscribe(new Consumer<String>() {

			@Override
			public void accept(String t) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		
		
		//observer.subscribe(new Subscriber())
		
Completable completable = new Completable() {
	
	@Override
	protected void subscribeActual(CompletableObserver s) {
		// TODO Auto-generated method stub
		
	}
};

	}

}
