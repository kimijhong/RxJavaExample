package operator.combine;

import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import comm.Shape;
import io.reactivex.Observable;

public class ZipWithExample {

	public void zipNumber() {
		
		
		
		Observable<Integer> observable = Observable.zip(Observable.just(100, 200, 300), Observable.just(10, 20, 30),
				Observable.just(1, 2, 3), (re1, re2, re3) -> {
					return re1 + re2 + re3;
				});
		
		observable = observable.zipWith(Observable.just(1, 2, 3), (abc, d) -> {

			return abc + d;
		});

		observable.subscribe(Log::i);

	}

	public static void main(String[] args) {

		new ZipWithExample().zipNumber();
	}

}
