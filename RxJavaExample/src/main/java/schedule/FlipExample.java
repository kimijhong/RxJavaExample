package schedule;

import comm.CommUtil;
import comm.Log;
import comm.Shape;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class FlipExample {

	
	
	public void emit()
	{
		String[] obj = {"1-S","2-T", "3-P"};
		
		
		Observable<String> observable = Observable.fromArray(obj)
				
				.doOnNext(data -> Log.v("original data = " + data))
				.observeOn(Schedulers.newThread()) // 데이터를 처리할때 스레드를 실행할것인지?
				.subscribeOn(Schedulers.newThread()) // subscribe()호출할때 쓰레드를 사용할것인지? 사용한다면 어떤 스레드
				.map(Shape::flip);
		         
		observable.subscribe(Log::i);
		CommUtil.sleep(500);
		
	
		
		
		
	}
	
	public static void main(String[] args) {
		
		FlipExample example = new FlipExample();
		example.emit();
	}	

}
