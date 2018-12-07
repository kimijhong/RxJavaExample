package schedule.schedulers;

import java.util.concurrent.TimeUnit;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ComputationSchedulerExample {
	public void emit()
	{
		String orgs[] = {"1","3","5"};
	Observable<String>	 observable = Observable.fromArray(orgs)
		.zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (a,b) -> a);
	    
	
	observable.map(data -> "<<" + data + ">>")
		.subscribeOn(Schedulers.computation())
		.subscribe(Log::i);
		//CommUtil.sleep(500);
		
	observable.map(data -> "##" + data + "##")
	.subscribeOn(Schedulers.computation())
	.subscribe(Log::i);
	
	observable.map(data -> "$$" + data + "##")
	.subscribeOn(Schedulers.computation())
	.subscribe(Log::i);
	
	observable.map(data -> "^^" + data + "##")
	.subscribeOn(Schedulers.computation())
	.subscribe(Log::i);
	
	observable.map(data -> "**" + data + "##")
	.subscribeOn(Schedulers.computation())
	.subscribe(Log::i);
	
		CommUtil.sleep(500);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComputationSchedulerExample example = new ComputationSchedulerExample();
		example.emit();
	}
	
	
}
