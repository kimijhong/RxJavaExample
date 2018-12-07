package observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservablefromFuture {
	
	
	
	public void basic()
	{

		/* 동시성 비동기 API 계산의 결과를 구할때 사용
		 * Executors 인터페이스를 구현한 클래스에 Callable객체를 인자로 넣어 Future객체를 반환
		 * Future를 활용하기보단 스케줄러를 사용하자
		 *  */
		Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
			Thread.sleep(1000);
			return "Hello Future";
		});

		Observable<String> observable6 = Observable.fromFuture(future).subscribeOn(Schedulers.newThread());
		observable6.subscribe(data -> {
			Log.i(data);
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ObservablefromFuture().basic();
	}

}
