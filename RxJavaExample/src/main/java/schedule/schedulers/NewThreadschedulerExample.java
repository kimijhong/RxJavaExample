package schedule.schedulers;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class NewThreadschedulerExample {
	
	
	public void emit()
	{
		String orgs[] = {"1","3","5"};
		Observable.fromArray(orgs)
		.doOnNext(data -> Log.v("original data : " + data ))
		.map(data -> "<<" + data + ">>")
		.subscribeOn(Schedulers.newThread())
		.subscribe(Log::i);
		//CommUtil.sleep(500);
		
		
		Observable.fromArray(orgs)
		.doOnNext(data -> Log.v("original data : " + data ))
		.map(data -> "##" + data + "##")
		.subscribeOn(Schedulers.newThread())
		.subscribe(Log::i);
		CommUtil.sleep(500);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewThreadschedulerExample example = new NewThreadschedulerExample();
		example.emit();
	}

}
