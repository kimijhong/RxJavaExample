package observable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DisposableExample {

	public static void main(String[] args) {

		Observable<String> observable = Observable.just("RED", "GREEN", "Yello");
		Disposable d = observable.subscribe(value -> {
			System.out.println("onNext() : value : " + value);
		}, err -> {
			System.out.println("onError() : err : " + err.getMessage());
		}, () -> {
			System.out.println("onComplete()");
		});

		d.dispose(); //구독자와의 관계를 끊는다. onComplete() 정상적으로 완료 되었을때 자동으로 호출된다.
		System.out.println(d.isDisposed()); // 정상적으로 완료 했는지

	}

}
