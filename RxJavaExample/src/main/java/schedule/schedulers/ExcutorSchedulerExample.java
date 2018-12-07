package schedule.schedulers;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ExcutorSchedulerExample {

	public void emit()
	{
		String orgs[] = {"1","3","5"};
		Observable<String> observable =   Observable.fromArray(orgs);
		ExecutorService executor = Executors.newFixedThreadPool(10);
	
		
		
		observable.subscribeOn(Schedulers.from(executor)).subscribe(Log::i);
		observable.subscribeOn(Schedulers.from(executor)).subscribe(Log::i);
		
		
		
		CommUtil.sleep(500);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcutorSchedulerExample example = new ExcutorSchedulerExample();
		example.emit();
	}

}
