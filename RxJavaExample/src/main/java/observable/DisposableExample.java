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

		d.dispose(); //�����ڿ��� ���踦 ���´�. onComplete() ���������� �Ϸ� �Ǿ����� �ڵ����� ȣ��ȴ�.
		System.out.println(d.isDisposed()); // ���������� �Ϸ� �ߴ���

	}

}
