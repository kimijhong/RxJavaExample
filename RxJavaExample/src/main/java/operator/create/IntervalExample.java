package operator.create;

import java.util.concurrent.TimeUnit;



import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;


/*
 * 일정 시간 간격으로 데이터 흐름 생성
 */
public class IntervalExample {

	public void emit()
	{
		CommUtil.exampleStart();
		Observable<Long> observable = Observable.interval(1000,100L, TimeUnit.MILLISECONDS)
				.map(data -> (data +1) * 100).take(5);
		observable.subscribe(Log::it);
		CommUtil.sleep(2000);
	}

	
	public static void main(String[] args) {

		new IntervalExample().emit();
	}
}
