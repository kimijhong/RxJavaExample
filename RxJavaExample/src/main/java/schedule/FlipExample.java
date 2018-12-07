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
				.observeOn(Schedulers.newThread()) // �����͸� ó���Ҷ� �����带 �����Ұ�����?
				.subscribeOn(Schedulers.newThread()) // subscribe()ȣ���Ҷ� �����带 ����Ұ�����? ����Ѵٸ� � ������
				.map(Shape::flip);
		         
		observable.subscribe(Log::i);
		CommUtil.sleep(500);
		
	
		
		
		
	}
	
	public static void main(String[] args) {
		
		FlipExample example = new FlipExample();
		example.emit();
	}	

}
