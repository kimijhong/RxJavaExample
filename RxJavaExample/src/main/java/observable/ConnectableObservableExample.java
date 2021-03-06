package observable;
import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableExample {

	/*
	 * Subject 클래스 처럼 차가운 Observable을 뜨거운 Observable로 변환
	 * 
	 * subscribe()함수를 호출해도 동작이 X 
	 * connect()함수를 호출한 시점부터 subscribe()를 호춯한 구독자에게 데이터 발행
	 * 
	 */
	public void emit() {
		String dt[] = { "1", "3", "5" };

		Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
				.map(Long::intValue)
				.map(i -> dt[i])
				.take(dt.length);
		
		ConnectableObservable<String> connectableObservable = balls.publish(); //고정
		connectableObservable.subscribe(data-> System.out.println("subscriber #1 =>" + data));
		connectableObservable.subscribe(data-> System.out.println("subscriber #2 =>" + data));
		connectableObservable.connect();
		
		CommUtil.sleep(250);
		connectableObservable.subscribe(data-> System.out.println("subscriber #3 =>" + data));
		CommUtil.sleep(1000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConnectableObservableExample().emit();
	}

}
