package operator.create;

import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;

public class IntervalRangeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Long> observable = Observable.intervalRange(1, 5, 100L, 100L, TimeUnit.MILLISECONDS);
		observable.subscribe(Log::it);
		CommUtil.sleep(1000);
		System.out.println("complete ~~");
		
		
		/**
		 * 기초함수 몇가지를 조합하면 만들수 있다.
		 */
		
		Observable<Long> observable2 = Observable.interval(100L, TimeUnit.MILLISECONDS).map(val -> val + 1).take(5);
		observable2.subscribe(Log::it);
	    CommUtil.sleep(1000);
	}

}
